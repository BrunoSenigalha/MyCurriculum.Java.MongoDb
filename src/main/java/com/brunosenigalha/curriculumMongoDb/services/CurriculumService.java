package com.brunosenigalha.curriculumMongoDb.services;

import com.brunosenigalha.curriculumMongoDb.converters.CurriculumConverter;
import com.brunosenigalha.curriculumMongoDb.converters.CurriculumMapper;
import com.brunosenigalha.curriculumMongoDb.dto.request.CurriculumRequestDTO;
import com.brunosenigalha.curriculumMongoDb.dto.response.CurriculumResponseDTO;
import com.brunosenigalha.curriculumMongoDb.entities.AddressEntity;
import com.brunosenigalha.curriculumMongoDb.entities.CurriculumEntity;
import com.brunosenigalha.curriculumMongoDb.repositories.CurriculumRepository;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.DatabaseException;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurriculumService {

    @Autowired
    private CurriculumRepository repository;
    @Autowired
    private CurriculumConverter converterData;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CurriculumMapper curriculumMapper;


    public List<CurriculumResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(curriculumMapper::forCurriculumResponseDTO)
                .toList();
    }


    public CurriculumEntity findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }


    public CurriculumEntity findByEmail(String email) {
        CurriculumEntity entity = repository.findByEmail(email);
        if (entity != null) {
            return repository.findByEmail(email);
        }
        throw new ResourceNotFoundException("Email not found");
    }


    public CurriculumResponseDTO insertCurriculum(CurriculumRequestDTO curriculumDTO) {
        try {
            CurriculumEntity curriculumEntity = curriculumAndAddressConverterToInsert(curriculumDTO);
            repository.save(curriculumEntity);

            return curriculumMapper.forCurriculumResponseDTO(curriculumEntity);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Database integrity violation:  " + e.getMessage());
        } catch (Exception e) {
            throw new DatabaseException("Error: Trying to save Curriculum " + e.getMessage());
        }
    }


    public CurriculumEntity update(String id, CurriculumRequestDTO objDTO) {
        return repository.findById(id).map(entity -> {
                    updateData(entity, objDTO);
                    return repository.save(entity);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }


    public void delete(String id) {
        CurriculumEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            repository.delete(entity);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }


    private CurriculumEntity curriculumAndAddressConverterToInsert(CurriculumRequestDTO curriculumDTO) {
        CurriculumEntity curriculumEntity = converterData.forCurriculumEntity(curriculumDTO);

        AddressEntity addressEntity = addressService.insertAddress(converterData.forAddressEntity(curriculumDTO.getAddress(), curriculumEntity.getId()));
        curriculumEntity.setAddress(addressEntity);

        return curriculumEntity;
    }

    private void updateData(CurriculumEntity entity, CurriculumRequestDTO objDTO) {
        entity.setPicture(objDTO.getPicture());
        entity.setName(objDTO.getName());
        entity.setGender(objDTO.getGender());
        entity.setProfessionalGoals(objDTO.getProfessionalGoals());
        entity.setPhone(objDTO.getPhone());
        entity.setEmail(objDTO.getEmail());
        entity.setLinkedIn(objDTO.getLinkedIn());

        AddressEntity addressEntity = addressService.updateAddress(entity.getAddress().getId(), objDTO.getAddress());
        entity.setAddress(addressEntity);
    }
}

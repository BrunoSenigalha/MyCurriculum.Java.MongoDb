package com.brunosenigalha.curriculumMongoDb.services;

import com.brunosenigalha.curriculumMongoDb.converters.ConverterData;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurriculumService {

    @Autowired
    private CurriculumRepository repository;
    @Autowired
    private ConverterData converterData;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CurriculumMapper curriculumMapper;


    public List<CurriculumResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(entity -> curriculumMapper.forCurriculumResponseDTO(entity))
                .collect(Collectors.toList());
    }


    public CurriculumEntity findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }


    public CurriculumEntity findByEmail(String email) {
        try {
            return repository.findByEmail(email);
        } catch (Exception e) {
            throw new ResourceNotFoundException(email + " " + e.getMessage());
        }
    }


    public CurriculumResponseDTO insertCurriculum(CurriculumRequestDTO curriculumDTO) {
        try {
            CurriculumEntity curriculumEntity = curriculumAndAddressConverter(curriculumDTO);
            repository.save(curriculumEntity);

            return curriculumMapper.forCurriculumResponseDTO(curriculumEntity);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Database integrity violation:  " + e.getMessage());
        } catch (Exception e) {
            throw new DatabaseException("Error: Trying to save Curriculum " + e.getMessage());
        }
    }


    public CurriculumEntity update(CurriculumEntity obj) {
        return repository.findById(obj.getId()).map(entity -> {
                    updateData(entity, obj);
                    return repository.save(entity);
                })
                .orElseThrow(() -> new ResourceNotFoundException(obj.getId()));
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


    private CurriculumEntity curriculumAndAddressConverter(CurriculumRequestDTO curriculumDTO){
        CurriculumEntity curriculumEntity = converterData.forCurriculumEntity(curriculumDTO);

        AddressEntity addressEntity = addressService.insertAddress(converterData.forAddressEntity(curriculumDTO.getAddress(), curriculumEntity.getId()));
        curriculumEntity.setAddress(addressEntity);

        return curriculumEntity;
    }


    private void updateData(CurriculumEntity entity, CurriculumEntity obj) {
        entity.setPicture(obj.getPicture());
        entity.setName(obj.getName());
        entity.setGender(obj.getGender());
        entity.setProfessionalGoals(obj.getProfessionalGoals());
        entity.setPhone(obj.getPhone());
        entity.setEmail(obj.getEmail());
        entity.setLinkedIn(obj.getLinkedIn());
    }
}

package com.brunosenigalha.curriculumMongoDb.services;

import com.brunosenigalha.curriculumMongoDb.converters.CurriculumConverter;
import com.brunosenigalha.curriculumMongoDb.dto.request.AddressRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.AddressEntity;
import com.brunosenigalha.curriculumMongoDb.repositories.AddressRepository;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CurriculumConverter converterData;

    public AddressEntity insertAddress(AddressEntity addressEntity) {
        return addressRepository.save(addressEntity);
    }

    public AddressEntity updateAddress(String id, AddressRequestDTO objDTO) {
        return addressRepository.findById(id).map(entity -> {
                    updateData(entity, objDTO);
                    return addressRepository.save(entity);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    private void updateData(AddressEntity entity, AddressRequestDTO objDTO) {
        entity.setZipCode(objDTO.getZipCode());
        entity.setState(objDTO.getState());
        entity.setCity(objDTO.getCity());
        entity.setCountry(objDTO.getCountry());
    }
}

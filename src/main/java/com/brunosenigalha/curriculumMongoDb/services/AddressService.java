package com.brunosenigalha.curriculumMongoDb.services;

import com.brunosenigalha.curriculumMongoDb.converters.ConverterData;
import com.brunosenigalha.curriculumMongoDb.dto.CurriculumDTO;
import com.brunosenigalha.curriculumMongoDb.entities.AddressEntity;
import com.brunosenigalha.curriculumMongoDb.entities.CurriculumEntity;
import com.brunosenigalha.curriculumMongoDb.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ConverterData converterData;

    public void insertAddress(AddressEntity addressEntity){
        addressRepository.save(addressEntity);
    }

    public void convertAddress(CurriculumDTO curriculumDTO, CurriculumEntity curriculumEntity){
        insertAddress(converterData.forAddressEntity(curriculumDTO.getAddress(),
                curriculumEntity.getId()));
    }
}

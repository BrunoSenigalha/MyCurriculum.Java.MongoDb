package com.brunosenigalha.curriculumMongoDb.services;

import com.brunosenigalha.curriculumMongoDb.converters.ConverterData;
import com.brunosenigalha.curriculumMongoDb.dto.request.CurriculumRequestDTO;
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

    public AddressEntity insertAddress(AddressEntity addressEntity){
        return addressRepository.save(addressEntity);
    }

//    public AddressEntity convertAddress(CurriculumRequestDTO curriculumDTO, CurriculumEntity curriculumEntity){
//       return insertAddress(converterData.forAddressEntity(curriculumDTO.getAddress(),
//                curriculumEntity.getId()));
//    }
}

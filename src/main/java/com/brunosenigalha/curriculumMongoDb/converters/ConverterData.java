package com.brunosenigalha.curriculumMongoDb.converters;

import com.brunosenigalha.curriculumMongoDb.dto.request.AddressRequestDTO;
import com.brunosenigalha.curriculumMongoDb.dto.request.CurriculumRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.AddressEntity;
import com.brunosenigalha.curriculumMongoDb.entities.CurriculumEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ConverterData {

    public CurriculumEntity forCurriculumEntity(CurriculumRequestDTO objDTO) {
        return CurriculumEntity.builder()
                .id(UUID.randomUUID().toString())
                .picture(objDTO.getPicture())
                .name(objDTO.getName())
                .gender(objDTO.getGender())
                .email(objDTO.getEmail())
                .professionalGoals(objDTO.getProfessionalGoals())
                .phone(objDTO.getPhone())
                .linkedIn(objDTO.getLinkedIn())
                .build();
    }

    public AddressEntity forAddressEntity(AddressRequestDTO objDTO, String id) {
        return AddressEntity.builder()
                .id(UUID.randomUUID().toString())
                .curriculumId(id)
                .zipCode(objDTO.getZipCode())
                .state(objDTO.getState())
                .city(objDTO.getCity())
                .country(objDTO.getCountry())
                .build();
    }
}

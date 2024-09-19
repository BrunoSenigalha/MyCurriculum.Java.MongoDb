package com.brunosenigalha.curriculumMongoDb.converters;

import com.brunosenigalha.curriculumMongoDb.dto.CurriculumDTO;
import com.brunosenigalha.curriculumMongoDb.entities.CurriculumEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ConverterData {

    public CurriculumEntity forCurriculumEntity(CurriculumDTO objDTO){
        return CurriculumEntity.builder()
                .id(UUID.randomUUID().toString())
                .picture(objDTO.picture())
                .name(objDTO.name())
                .gender(objDTO.gender())
                .email(objDTO.email())
                .professionalGoals(objDTO.professionalGoals())
                .phone(objDTO.phone())
                .linkedIn(objDTO.linkedIn())
                .build();
    }
}

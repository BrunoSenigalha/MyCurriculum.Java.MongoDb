package com.brunosenigalha.curriculumMongoDb.converters;

import com.brunosenigalha.curriculumMongoDb.dto.CurriculumDTO;
import com.brunosenigalha.curriculumMongoDb.entities.CurriculumEntity;


public class ConverterData {
    public static CurriculumEntity curriculumFromDTO(CurriculumDTO objDTO){
        return new CurriculumEntity(objDTO.id(), objDTO.picture(), objDTO.gender(), objDTO.professionalGoals(), objDTO.phone(),
                objDTO.email(), objDTO.linkedIn());
    }

}

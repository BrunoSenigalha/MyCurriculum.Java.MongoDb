package com.brunosenigalha.curriculumMongoDb.converters;

import com.brunosenigalha.curriculumMongoDb.dto.request.AcademicExpRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.AcademicExpEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AcademicExpConverter {

    public AcademicExpEntity forAcademicExpEntity(AcademicExpRequestDTO objDTO) {
        return AcademicExpEntity.builder()
                .id(UUID.randomUUID().toString())
                .curriculumId(objDTO.getCurriculumId())
                .courseName(objDTO.getCourseName())
                .institution(objDTO.getInstitution())
                .degree(objDTO.getDegree())
                .formationStatus(objDTO.getFormationStatus())
                .formationType(objDTO.getFormationType())
                .studying(objDTO.getStudying())
                .startDate(objDTO.getStartDate())
                .endDate(objDTO.getEndDate())
                .build();
    }
}

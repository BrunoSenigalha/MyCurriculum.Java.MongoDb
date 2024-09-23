package com.brunosenigalha.curriculumMongoDb.converters;

import com.brunosenigalha.curriculumMongoDb.dto.request.CourseRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.CourseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CourseConverter {

    public CourseEntity forCourseEntity(CourseRequestDTO objDTO){
        return CourseEntity.builder()
                .id(UUID.randomUUID().toString())
                .curriculumId(objDTO.getCurriculumId())
                .typeCourse(objDTO.getTypeCourse())
                .title(objDTO.getTitle())
                .description(objDTO.getDescription())
                .build();
    }
}

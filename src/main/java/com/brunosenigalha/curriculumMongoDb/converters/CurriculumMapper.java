package com.brunosenigalha.curriculumMongoDb.converters;

import com.brunosenigalha.curriculumMongoDb.dto.response.CurriculumResponseDTO;
import com.brunosenigalha.curriculumMongoDb.entities.CurriculumEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CurriculumMapper {

    @Mapping(target = "id", source = "curriculum.id")
    @Mapping(target = "picture", source = "curriculum.picture")
    @Mapping(target = "name", source = "curriculum.name")
    @Mapping(target = "gender", source = "curriculum.gender")
    @Mapping(target = "professionalGoals", source = "curriculum.professionalGoals")
    @Mapping(target = "phone", source = "curriculum.phone")
    @Mapping(target = "email", source = "curriculum.email")
    @Mapping(target = "linkedIn", source = "curriculum.linkedIn")
    @Mapping(target = "address", source = "curriculum.address")
    CurriculumResponseDTO forCurriculumResponseDTO(CurriculumEntity curriculum);

}

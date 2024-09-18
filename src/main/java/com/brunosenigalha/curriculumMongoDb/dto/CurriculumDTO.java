package com.brunosenigalha.curriculumMongoDb.dto;

import com.brunosenigalha.curriculumMongoDb.entities.AddressEntity;
import com.brunosenigalha.curriculumMongoDb.entities.enums.Gender;

public record CurriculumDTO(
        String id,
        String picture,
        String name,
        Gender gender,
        String professionalGoals,
        String phone,
        String email,
        String linkedIn,
        AddressEntity address) {
}

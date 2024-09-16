package com.brunosenigalha.curriculumMongoDb.dto.response;

import com.brunosenigalha.curriculumMongoDb.entities.enums.Gender;

public record CurriculumResponseDTO(
        String id,
        String picture,
        String name,
        Gender gender,
        String professionalGoals,
        String phone,
        String email,
        String linkedIn,
        AddressResponseDTO address) {
}

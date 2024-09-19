package com.brunosenigalha.curriculumMongoDb.dto.response;

public record AddressResponseDTO(
   String zipCode,
   String state,
   String city,
   String country) {
}

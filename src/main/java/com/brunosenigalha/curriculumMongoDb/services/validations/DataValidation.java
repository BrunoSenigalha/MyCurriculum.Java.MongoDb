package com.brunosenigalha.curriculumMongoDb.services.validations;


import java.time.LocalDate;

public class DataValidation {

    public static void dataValidation(LocalDate startDate, LocalDate endDate) {
        LocalDate today = LocalDate.now();

        if (endDate.isAfter(today)) {
            throw new IllegalArgumentException("End date can't be after current date");
        }
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date can't be after end date");
        }
    }

    public static void dataValidationWithoutLimit(LocalDate startDate, LocalDate endDate){
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date can't be after end date");
        }
    }
}

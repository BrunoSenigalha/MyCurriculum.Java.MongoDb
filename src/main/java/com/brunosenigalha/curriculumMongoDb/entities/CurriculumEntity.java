package com.brunosenigalha.curriculumMongoDb.entities;

import com.brunosenigalha.curriculumMongoDb.dto.request.AddressRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.enums.Gender;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "curriculum")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurriculumEntity implements Serializable {

    @Id
    private String id;
    private String picture;
    private String name;
    private Gender gender;
    private String professionalGoals;
    private String phone;
    private String email;
    private String linkedIn;

    private AddressRequestDTO addressDTO;

    @DBRef(lazy = true)
    private List<Course> courses = new ArrayList<>();

    @DBRef(lazy = true)
    private List<AcademicExp> academicExpList = new ArrayList<>();

}

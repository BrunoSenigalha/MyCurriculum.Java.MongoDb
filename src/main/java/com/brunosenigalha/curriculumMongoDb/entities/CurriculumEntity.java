package com.brunosenigalha.curriculumMongoDb.entities;

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

    private AddressEntity address;

    @DBRef(lazy = true)
    private List<Course> courses = new ArrayList<>();

    @DBRef(lazy = true)
    private List<AcademicExp> academicExpList = new ArrayList<>();

    public CurriculumEntity(String picture, String name, Gender gender, String professionalGoals, String phone, String email, String linkedIn) {
        this.picture = picture;
        this.name = name;
        this.gender = gender;
        this.professionalGoals = professionalGoals;
        this.phone = phone;
        this.email = email;
        this.linkedIn = linkedIn;
    }
}

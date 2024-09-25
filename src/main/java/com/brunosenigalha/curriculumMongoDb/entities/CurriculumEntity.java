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
@EqualsAndHashCode
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

    @DBRef(lazy = true)
    private AddressEntity address;

    @DBRef(lazy = true)
    private List<CourseEntity> courses = new ArrayList<>();

    @DBRef(lazy = true)
    private List<AcademicExpEntity> academicExpList = new ArrayList<>();

    @DBRef(lazy = true)
    private List<LanguageEntity> languages = new ArrayList<>();

    @DBRef(lazy = true)
    private List<LinkEntity> links = new ArrayList<>();

    public CurriculumEntity(String id, String picture, String name, Gender gender, String professionalGoals, String phone, String email, String linkedIn) {
        this.id = id;
        this.picture = picture;
        this.name = name;
        this.gender = gender;
        this.professionalGoals = professionalGoals;
        this.phone = phone;
        this.email = email;
        this.linkedIn = linkedIn;
    }

}

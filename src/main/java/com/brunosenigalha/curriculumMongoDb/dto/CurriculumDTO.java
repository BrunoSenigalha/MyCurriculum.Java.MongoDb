package com.brunosenigalha.curriculumMongoDb.dto;

import com.brunosenigalha.curriculumMongoDb.entities.enums.Gender;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class CurriculumDTO {
        private String id;
        private String picture;
        private String name;
        private Gender gender;
        private String professionalGoals;
        private String phone;
        private String email;
        private String linkedIn;
        private AddressDTO address;
}

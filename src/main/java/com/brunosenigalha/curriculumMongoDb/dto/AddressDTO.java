package com.brunosenigalha.curriculumMongoDb.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AddressDTO {
       private String zipCode;
       private String state;
       private String city;
       private String country;

}

package com.brunosenigalha.curriculumMongoDb.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AddressRequestDTO {
       private String zipCode;
       private String state;
       private String city;
       private String country;

}

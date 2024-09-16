package com.brunosenigalha.curriculumMongoDb.dto.request;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class AddressRequestDTO implements Serializable {

    private String zipCode;
    private String state;
    private String city;
    private String country;


}



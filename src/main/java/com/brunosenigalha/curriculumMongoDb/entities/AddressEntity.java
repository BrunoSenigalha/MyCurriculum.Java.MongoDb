package com.brunosenigalha.curriculumMongoDb.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressEntity {

    @Id
    private String id;
    private String curriculumId;
    private String zipCode;
    private String state;
    private String city;
    private String country;
}

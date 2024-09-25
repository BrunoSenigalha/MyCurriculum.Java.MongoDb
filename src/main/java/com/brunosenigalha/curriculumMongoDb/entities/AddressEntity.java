package com.brunosenigalha.curriculumMongoDb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressEntity implements Serializable {

    @Id
    private String id;
    private String curriculumId;
    private String zipCode;
    private String state;
    private String city;
    private String country;

    @JsonIgnore
    private Object target;

    @JsonIgnore
    private Object source;

    public AddressEntity(String id, String curriculumId, String zipCode, String state, String city, String country) {
        this.id = id;
        this.curriculumId = curriculumId;
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
        this.country = country;
    }
}

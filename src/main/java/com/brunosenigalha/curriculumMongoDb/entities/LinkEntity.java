package com.brunosenigalha.curriculumMongoDb.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "links")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class LinkEntity implements Serializable {

    @Id
    private String id;
    private String curriculumId;
    private String link;
}

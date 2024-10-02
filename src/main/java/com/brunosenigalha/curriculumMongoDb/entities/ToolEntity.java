package com.brunosenigalha.curriculumMongoDb.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tools")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ToolEntity {

    @Id
    private String id;
//    private String curriculumId;
    private String name;

}

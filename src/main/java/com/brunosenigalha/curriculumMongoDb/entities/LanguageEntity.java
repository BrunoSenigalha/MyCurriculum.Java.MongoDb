package com.brunosenigalha.curriculumMongoDb.entities;

import com.brunosenigalha.curriculumMongoDb.entities.enums.ProficiencyLevel;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "languages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class LanguageEntity implements Serializable {

    @Id
    private String id;
    private String curriculumId;
    private String language;
    private ProficiencyLevel conversationLevel;
    private ProficiencyLevel comprehensionLevel;
    private ProficiencyLevel writingLevel;
}

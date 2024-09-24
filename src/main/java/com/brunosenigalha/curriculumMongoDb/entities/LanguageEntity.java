package com.brunosenigalha.curriculumMongoDb.entities;

import com.brunosenigalha.curriculumMongoDb.entities.enums.ProficiencyLevel;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "languages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class LanguageEntity {

    @Id
    private String id;
    private String curriculumId;
    private String language;
    private ProficiencyLevel conversationLevel;
    private ProficiencyLevel comprehensionLevel;
    private ProficiencyLevel writingLevel;
}

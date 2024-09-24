package com.brunosenigalha.curriculumMongoDb.dto.request;

import com.brunosenigalha.curriculumMongoDb.entities.enums.ProficiencyLevel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class LanguageRequestDTO {
    private String curriculumId;
    private String language;
    private ProficiencyLevel conversationLevel;
    private ProficiencyLevel comprehensionLevel;
    private ProficiencyLevel writingLevel;
}

package com.brunosenigalha.curriculumMongoDb.converters;

import com.brunosenigalha.curriculumMongoDb.dto.request.LanguageRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.LanguageEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LanguageConverter {

    public LanguageEntity forLanguageEntity(LanguageRequestDTO objDTO) {
        return LanguageEntity.builder()
                .id(UUID.randomUUID().toString())
                .curriculumId(objDTO.getCurriculumId())
                .language(objDTO.getLanguage())
                .conversationLevel(objDTO.getConversationLevel())
                .comprehensionLevel(objDTO.getComprehensionLevel())
                .writingLevel(objDTO.getWritingLevel())
                .build();
    }
}

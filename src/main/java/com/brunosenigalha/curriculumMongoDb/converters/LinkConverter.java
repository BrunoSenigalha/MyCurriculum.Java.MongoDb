package com.brunosenigalha.curriculumMongoDb.converters;

import com.brunosenigalha.curriculumMongoDb.dto.request.LanguageRequestDTO;
import com.brunosenigalha.curriculumMongoDb.dto.request.LinkRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.LanguageEntity;
import com.brunosenigalha.curriculumMongoDb.entities.LinkEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LinkConverter {

    public LinkEntity forLinkEntity(LinkRequestDTO objDTO) {
        return LinkEntity.builder()
                .id(UUID.randomUUID().toString())
                .curriculumId(objDTO.getCurriculumId())
                .link(objDTO.getLink())
                .build();
    }
}

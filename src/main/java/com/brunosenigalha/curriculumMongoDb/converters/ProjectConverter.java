package com.brunosenigalha.curriculumMongoDb.converters;

import com.brunosenigalha.curriculumMongoDb.dto.request.ProjectRequestDTO;
import com.brunosenigalha.curriculumMongoDb.dto.request.ToolRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.ProjectEntity;
import com.brunosenigalha.curriculumMongoDb.entities.ToolEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProjectConverter {

    public ProjectEntity forProjectEntity(ProjectRequestDTO objDTO) {
        return ProjectEntity.builder()
                .id(UUID.randomUUID().toString())
                .curriculumId(objDTO.getCurriculumId())
                .projectName(objDTO.getProjectName())
                .link(objDTO.getLink())
                .description(objDTO.getDescription())
                .build();

    }

    public ToolEntity forToolEntity(ToolRequestDTO objDTO){
        return ToolEntity.builder()
                .id(UUID.randomUUID().toString())
                .tool(objDTO.getTool())
                .build();
    }
}

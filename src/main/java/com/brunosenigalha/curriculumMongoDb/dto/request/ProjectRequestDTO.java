package com.brunosenigalha.curriculumMongoDb.dto.request;

import com.brunosenigalha.curriculumMongoDb.entities.ProjectEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class ProjectRequestDTO {

    private String curriculumId;
    private String projectName;
    private String link;
    private String description;
    private List<ProjectEntity> projects = new ArrayList<>();

}

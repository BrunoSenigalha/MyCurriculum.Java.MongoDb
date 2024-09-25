package com.brunosenigalha.curriculumMongoDb.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "projects")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ProjectEntity {

    @Id
    private String id;
    private String curriculumId;
    private String projectName;
    private String link;
    private String description;

    private List<ToolEntity> tools = new ArrayList<>();

    public ProjectEntity(String id, String curriculumId, String projectName, String link, String description) {
        this.id = id;
        this.curriculumId = curriculumId;
        this.projectName = projectName;
        this.link = link;
        this.description = description;
    }
}

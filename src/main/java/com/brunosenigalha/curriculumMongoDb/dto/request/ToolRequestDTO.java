package com.brunosenigalha.curriculumMongoDb.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class ToolRequestDTO {

    private String curriculumId;
    private String name;
}

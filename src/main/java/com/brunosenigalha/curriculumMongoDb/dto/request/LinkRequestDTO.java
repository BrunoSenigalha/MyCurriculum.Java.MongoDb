package com.brunosenigalha.curriculumMongoDb.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class LinkRequestDTO {

    private String curriculumId;
    private String link;
}

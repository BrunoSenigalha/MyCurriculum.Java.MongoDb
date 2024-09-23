package com.brunosenigalha.curriculumMongoDb.dto.request;

import com.brunosenigalha.curriculumMongoDb.entities.enums.TypeCourse;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class CourseRequestDTO {
    private String curriculumId;
    private TypeCourse typeCourse;
    private String title;
    private String description;
}

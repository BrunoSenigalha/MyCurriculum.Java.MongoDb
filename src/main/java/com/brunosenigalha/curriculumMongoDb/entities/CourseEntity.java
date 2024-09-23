package com.brunosenigalha.curriculumMongoDb.entities;

import com.brunosenigalha.curriculumMongoDb.entities.enums.TypeCourse;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document(collection = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class CourseEntity implements Serializable {

    @Id
    private String id;
    private String curriculumId;
    private TypeCourse typeCourse;
    private String title;
    private String description;
}

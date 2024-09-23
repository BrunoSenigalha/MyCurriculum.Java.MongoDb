package com.brunosenigalha.curriculumMongoDb.entities;

import com.brunosenigalha.curriculumMongoDb.entities.enums.Degree;
import com.brunosenigalha.curriculumMongoDb.entities.enums.FormationStatus;
import com.brunosenigalha.curriculumMongoDb.entities.enums.FormationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document(collection = "academic_experiences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AcademicExpEntity implements Serializable {

    @Id
    private String id;
    private String courseName;
    private String institution;
    private Degree degree;
    private FormationType formationType;
    private FormationStatus formationStatus;
    private Boolean studying;
    private LocalDate startDate;
    private LocalDate endDate;

}

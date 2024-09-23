package com.brunosenigalha.curriculumMongoDb.dto.request;


import com.brunosenigalha.curriculumMongoDb.entities.enums.Degree;
import com.brunosenigalha.curriculumMongoDb.entities.enums.FormationStatus;
import com.brunosenigalha.curriculumMongoDb.entities.enums.FormationType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class AcademicExpRequestDTO {
    private String curriculumId;
    private String courseName;
    private String institution;
    private Degree degree;
    private FormationType formationType;
    private FormationStatus formationStatus;
    private Boolean studying;
    private LocalDate startDate;
    private LocalDate endDate;
}

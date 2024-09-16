package com.brunosenigalha.curriculumMongoDb.entities;

import com.brunosenigalha.curriculumMongoDb.entities.enums.Degree;
import com.brunosenigalha.curriculumMongoDb.entities.enums.FormationStatus;
import com.brunosenigalha.curriculumMongoDb.entities.enums.FormationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Document(collation = "academic_experiences")
public class AcademicExp implements Serializable {

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



    public AcademicExp() {
    }

    public AcademicExp(String id, String courseName, String institution, Degree degree, FormationType formationType, FormationStatus formationStatus, Boolean studying, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.courseName = courseName;
        this.institution = institution;
        this.degree = degree;
        this.formationType = formationType;
        this.formationStatus = formationStatus;
        this.studying = studying;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public FormationType getFormationType() {
        return formationType;
    }

    public void setFormationType(FormationType formationType) {
        this.formationType = formationType;
    }

    public FormationStatus getFormationStatus() {
        return formationStatus;
    }

    public void setFormationStatus(FormationStatus formationStatus) {
        this.formationStatus = formationStatus;
    }

    public Boolean getStudying() {
        return studying;
    }

    public void setStudying(Boolean studying) {
        this.studying = studying;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademicExp that = (AcademicExp) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

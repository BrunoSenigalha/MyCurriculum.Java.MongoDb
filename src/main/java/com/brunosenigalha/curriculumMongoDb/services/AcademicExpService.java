package com.brunosenigalha.curriculumMongoDb.services;

import com.brunosenigalha.curriculumMongoDb.entities.AcademicExpEntity;
import com.brunosenigalha.curriculumMongoDb.repositories.AcademicExpRepository;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.DatabaseException;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.InvalidDateException;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.ResourceNotFoundException;
import com.brunosenigalha.curriculumMongoDb.services.validations.DataValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicExpService {

    @Autowired
    private AcademicExpRepository repository;

    public List<AcademicExpEntity> findAll() {
        return repository.findAll();
    }

    public AcademicExpEntity findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public AcademicExpEntity insert(AcademicExpEntity obj) {
        try {
            DataValidation.dataValidationWithoutLimit(obj.getStartDate(), obj.getEndDate());
            return repository.save(obj);
        } catch (IllegalArgumentException e) {
            throw new InvalidDateException(e.getMessage());
        }
    }

    public AcademicExpEntity update(String id, AcademicExpEntity obj) {
        AcademicExpEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            DataValidation.dataValidationWithoutLimit(obj.getStartDate(), obj.getEndDate());
            updateData(entity, obj);
            return repository.save(entity);
        } catch (IllegalArgumentException e) {
            throw new InvalidDateException(e.getMessage());
        }
    }

    public void delete(String id) {
        AcademicExpEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            repository.delete(entity);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(AcademicExpEntity entity, AcademicExpEntity obj) {
        entity.setCourseName(obj.getCourseName());
        entity.setInstitution(obj.getInstitution());
        entity.setDegree(obj.getDegree());
        entity.setFormationType(obj.getFormationType());
        entity.setFormationStatus(obj.getFormationStatus());
        entity.setStudying(obj.getStudying());
        entity.setStartDate(obj.getStartDate());
        entity.setEndDate(obj.getEndDate());
    }
}

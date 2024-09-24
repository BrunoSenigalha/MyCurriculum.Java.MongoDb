package com.brunosenigalha.curriculumMongoDb.services;

import com.brunosenigalha.curriculumMongoDb.converters.AcademicExpConverter;
import com.brunosenigalha.curriculumMongoDb.dto.request.AcademicExpRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.AcademicExpEntity;
import com.brunosenigalha.curriculumMongoDb.entities.CurriculumEntity;
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
    @Autowired
    private AcademicExpConverter converter;
    @Autowired
    private CurriculumService curriculumService;


    public List<AcademicExpEntity> findAll() {
        return repository.findAll();
    }

    public AcademicExpEntity findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public AcademicExpEntity insert(AcademicExpRequestDTO objDTO) {
        try {
            DataValidation.dataValidationForAcademicExp(objDTO.getStartDate(), objDTO.getEndDate());
            AcademicExpEntity entity = converter.forAcademicExpEntity(objDTO);
            addAcademicExpToCurriculum(entity);

            return repository.save(entity);
        } catch (IllegalArgumentException e) {
            throw new InvalidDateException(e.getMessage());
        }
    }

    public AcademicExpEntity update(String id, AcademicExpRequestDTO objDTO) {
        AcademicExpEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            DataValidation.dataValidationForAcademicExp(objDTO.getStartDate(), objDTO.getEndDate());
            updateData(entity, objDTO);
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

    private void addAcademicExpToCurriculum(AcademicExpEntity obj) {
        CurriculumEntity entity = curriculumService.findById(obj.getCurriculumId());
        entity.getAcademicExpList().add(obj);
        curriculumService.saveCurriculum(entity);
    }


    private void updateData(AcademicExpEntity entity, AcademicExpRequestDTO objDTO) {
        entity.setCourseName(objDTO.getCourseName());
        entity.setInstitution(objDTO.getInstitution());
        entity.setDegree(objDTO.getDegree());
        entity.setFormationType(objDTO.getFormationType());
        entity.setFormationStatus(objDTO.getFormationStatus());
        entity.setStudying(objDTO.getStudying());
        entity.setStartDate(objDTO.getStartDate());
        entity.setEndDate(objDTO.getEndDate());
    }
}

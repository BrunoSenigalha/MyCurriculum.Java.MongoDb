package com.brunosenigalha.curriculumMongoDb.services;

import com.brunosenigalha.curriculumMongoDb.entities.CurriculumEntity;
import com.brunosenigalha.curriculumMongoDb.repositories.CurriculumRepository;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.DatabaseException;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumService {

    @Autowired
    private CurriculumRepository repository;


    public List<CurriculumEntity> findAll() {
        return repository.findAll();
    }

    public CurriculumEntity findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public CurriculumEntity insert(CurriculumEntity obj) {
        return repository.save(obj);
    }

    public CurriculumEntity update(CurriculumEntity obj) {
        return repository.findById(obj.getId()).map(entity -> {
                    updateData(entity, obj);
                    return repository.save(entity);
                })
                .orElseThrow(() -> new ResourceNotFoundException(obj.getId()));
    }

    public void delete(String id) {
        CurriculumEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            repository.delete(entity);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(CurriculumEntity entity, CurriculumEntity obj){
        entity.setPicture(obj.getPicture());
        entity.setName(obj.getName());
        entity.setGender(obj.getGender());
        entity.setProfessionalGoals(obj.getProfessionalGoals());
        entity.setPhone(obj.getPhone());
        entity.setEmail(obj.getEmail());
        entity.setLinkedIn(obj.getLinkedIn());
    }
}

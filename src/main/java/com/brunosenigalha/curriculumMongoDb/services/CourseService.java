package com.brunosenigalha.curriculumMongoDb.services;

import com.brunosenigalha.curriculumMongoDb.entities.CourseEntity;
import com.brunosenigalha.curriculumMongoDb.repositories.CourseRepository;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.DatabaseException;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public List<CourseEntity> findAll() {
        return repository.findAll();
    }

    public CourseEntity findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public CourseEntity insert(CourseEntity obj) {
        return repository.save(obj);
    }

    public CourseEntity update(String id, CourseEntity obj){
        return repository.findById(id)
                .map(entity -> {
                    updateData(entity, obj);
                    return repository.save(entity);
                })
                .orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public void delete(String id){
        CourseEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try{
            repository.delete(entity);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(CourseEntity entity, CourseEntity obj){
        entity.setTypeCourse(obj.getTypeCourse());
        entity.setTitle(obj.getTitle());
        entity.setDescription(obj.getDescription());
    }
}

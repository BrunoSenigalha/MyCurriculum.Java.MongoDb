package com.brunosenigalha.curriculumMongoDb.services;

import com.brunosenigalha.curriculumMongoDb.entities.Course;
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

    public List<Course> findAll() {
        return repository.findAll();
    }

    public Course findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Course insert(Course obj) {
        return repository.save(obj);
    }

    public Course update(String id, Course obj){
        return repository.findById(id)
                .map(entity -> {
                    updateData(entity, obj);
                    return repository.save(entity);
                })
                .orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public void delete(String id){
        Course entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try{
            repository.delete(entity);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(Course entity, Course obj){
        entity.setTypeCourse(obj.getTypeCourse());
        entity.setTitle(obj.getTitle());
        entity.setDescription(obj.getDescription());
    }
}

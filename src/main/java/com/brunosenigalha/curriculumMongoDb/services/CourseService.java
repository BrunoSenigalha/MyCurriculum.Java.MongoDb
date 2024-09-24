package com.brunosenigalha.curriculumMongoDb.services;

import com.brunosenigalha.curriculumMongoDb.converters.CourseConverter;
import com.brunosenigalha.curriculumMongoDb.dto.request.CourseRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.CourseEntity;
import com.brunosenigalha.curriculumMongoDb.entities.CurriculumEntity;
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
    @Autowired
    private CourseConverter converter;
    @Autowired
    private CurriculumService curriculumService;

    public List<CourseEntity> findAll() {
        return repository.findAll();
    }

    public CourseEntity findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public CourseEntity insert(CourseRequestDTO objDTO) {
        CourseEntity entity = converter.forCourseEntity(objDTO);
        addCourseToCurriculum(entity);
        return repository.save(entity);
    }

    public CourseEntity update(String id, CourseRequestDTO objDTO) {
        return repository.findById(id)
                .map(entity -> {
                    updateData(entity, objDTO);
                    return repository.save(entity);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(String id) {
        CourseEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            repository.delete(entity);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void addCourseToCurriculum(CourseEntity obj) {
        CurriculumEntity entity = curriculumService.findById(obj.getCurriculumId());
        entity.getCourses().add(obj);
        curriculumService.saveCurriculum(entity);
    }

    private void updateData(CourseEntity entity, CourseRequestDTO objDTO) {
        entity.setTypeCourse(objDTO.getTypeCourse());
        entity.setTitle(objDTO.getTitle());
        entity.setDescription(objDTO.getDescription());
    }
}

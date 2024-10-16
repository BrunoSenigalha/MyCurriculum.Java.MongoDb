package com.brunosenigalha.curriculumMongoDb.services;

import com.brunosenigalha.curriculumMongoDb.converters.ProjectConverter;
import com.brunosenigalha.curriculumMongoDb.dto.request.ToolRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.CurriculumEntity;
import com.brunosenigalha.curriculumMongoDb.entities.ToolEntity;
import com.brunosenigalha.curriculumMongoDb.repositories.ToolRepository;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.DatabaseException;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.ResourceNotFoundException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolService {

    @Autowired
    private ToolRepository repository;
    @Autowired
    private ProjectConverter converter;
    @Autowired
    private CurriculumService curriculumService;

    public List<ToolEntity> findAll() {
        return repository.findAll();
    }

    public ToolEntity findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public ToolEntity findByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }

    public ToolEntity insert(String id, ToolRequestDTO objDTO) {
        ToolEntity entity = converter.forToolEntity(objDTO);
        addToolToCurriculum(entity, id);
        repository.save(entity);
        return entity;
    }

    public void delete(String id) {
        ToolEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            repository.delete(entity);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    private void addToolToCurriculum(ToolEntity obj, String id) {
        CurriculumEntity entity = curriculumService.findById(id);
        entity.getTools().add(obj);
        curriculumService.saveCurriculum(entity);
    }
}

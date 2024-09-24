package com.brunosenigalha.curriculumMongoDb.services;

import com.brunosenigalha.curriculumMongoDb.converters.LanguageConverter;
import com.brunosenigalha.curriculumMongoDb.dto.request.LanguageRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.CurriculumEntity;
import com.brunosenigalha.curriculumMongoDb.entities.LanguageEntity;
import com.brunosenigalha.curriculumMongoDb.repositories.LanguageRepository;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.DatabaseException;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.InvalidDateException;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository repository;
    @Autowired
    private LanguageConverter converter;
    @Autowired
    private CurriculumService curriculumService;


    public List<LanguageEntity> findAll() {
        return repository.findAll();
    }

    public LanguageEntity findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public LanguageEntity insert(LanguageRequestDTO objDTO) {
        LanguageEntity entity = converter.forLanguageEntity(objDTO);
        addLanguageToCurriculum(entity);
        return repository.save(entity);

    }

    public LanguageEntity update(String id, LanguageRequestDTO objDTO) {
        LanguageEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            updateData(entity, objDTO);
            return repository.save(entity);
        } catch (IllegalArgumentException e) {
            throw new InvalidDateException(e.getMessage());
        }
    }

    public void delete(String id) {
        LanguageEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            repository.delete(entity);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void addLanguageToCurriculum(LanguageEntity obj) {
        CurriculumEntity entity = curriculumService.findById(obj.getCurriculumId());
        entity.getLanguages().add(obj);
        curriculumService.saveCurriculum(entity);
    }


    private void updateData(LanguageEntity entity, LanguageRequestDTO objDTO) {
        entity.setLanguage(objDTO.getLanguage());
        entity.setComprehensionLevel(objDTO.getComprehensionLevel());
        entity.setConversationLevel(objDTO.getConversationLevel());
        entity.setWritingLevel(objDTO.getWritingLevel());
    }
}

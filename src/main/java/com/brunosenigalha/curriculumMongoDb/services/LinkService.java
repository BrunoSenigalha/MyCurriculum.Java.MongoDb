package com.brunosenigalha.curriculumMongoDb.services;

import com.brunosenigalha.curriculumMongoDb.converters.LanguageConverter;
import com.brunosenigalha.curriculumMongoDb.converters.LinkConverter;
import com.brunosenigalha.curriculumMongoDb.dto.request.LanguageRequestDTO;
import com.brunosenigalha.curriculumMongoDb.dto.request.LinkRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.CurriculumEntity;
import com.brunosenigalha.curriculumMongoDb.entities.LanguageEntity;
import com.brunosenigalha.curriculumMongoDb.entities.LinkEntity;
import com.brunosenigalha.curriculumMongoDb.repositories.LanguageRepository;
import com.brunosenigalha.curriculumMongoDb.repositories.LinkRepository;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.DatabaseException;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.InvalidDateException;
import com.brunosenigalha.curriculumMongoDb.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LinkService {

    @Autowired
    private LinkRepository repository;
    @Autowired
    private LinkConverter converter;
    @Autowired
    private CurriculumService curriculumService;


    public List<LinkEntity> findAll() {
        return repository.findAll();
    }

    public LinkEntity insert(LinkRequestDTO objDTO) {
        LinkEntity entity = converter.forLinkEntity(objDTO);
        addLanguageToCurriculum(entity);
        return repository.save(entity);

    }

    public LinkEntity update(String id, LinkRequestDTO objDTO) {
        LinkEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            updateData(entity, objDTO);
            return repository.save(entity);
        } catch (IllegalArgumentException e) {
            throw new InvalidDateException(e.getMessage());
        }
    }

    public void delete(String id) {
        LinkEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            repository.delete(entity);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void addLanguageToCurriculum(LinkEntity obj) {
        CurriculumEntity entity = curriculumService.findById(obj.getCurriculumId());
        entity.getLinks().add(obj);
        curriculumService.saveCurriculum(entity);
    }


    private void updateData(LinkEntity entity, LinkRequestDTO objDTO) {
        entity.setLink(objDTO.getLink());
    }
}

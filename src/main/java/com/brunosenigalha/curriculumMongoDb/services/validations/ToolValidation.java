package com.brunosenigalha.curriculumMongoDb.services.validations;

import com.brunosenigalha.curriculumMongoDb.entities.ToolEntity;
import com.brunosenigalha.curriculumMongoDb.repositories.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolValidation {

    @Autowired
    private ToolRepository repository;

    public ToolEntity checkingIfToolExists(String name) {
        return repository.findByNameIgnoreCase(name);
    }
}

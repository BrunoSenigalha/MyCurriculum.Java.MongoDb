package com.brunosenigalha.curriculumMongoDb.services;

import com.brunosenigalha.curriculumMongoDb.entities.Curriculum;
import com.brunosenigalha.curriculumMongoDb.repositories.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumService {

    @Autowired
    private CurriculumRepository repository;

    public List<Curriculum> findAll() {
        return repository.findAll();
    }
}

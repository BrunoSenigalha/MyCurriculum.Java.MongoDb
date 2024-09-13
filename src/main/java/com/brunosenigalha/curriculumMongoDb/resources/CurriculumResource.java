package com.brunosenigalha.curriculumMongoDb.resources;

import com.brunosenigalha.curriculumMongoDb.entities.Curriculum;
import com.brunosenigalha.curriculumMongoDb.services.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/curricula")
public class CurriculumResource {

    @Autowired
    public CurriculumService service;

    @GetMapping
    public ResponseEntity<List<Curriculum>> findAll() {
        List<Curriculum> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}

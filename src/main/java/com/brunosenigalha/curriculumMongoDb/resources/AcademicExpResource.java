package com.brunosenigalha.curriculumMongoDb.resources;

import com.brunosenigalha.curriculumMongoDb.entities.AcademicExp;
import com.brunosenigalha.curriculumMongoDb.services.AcademicExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/academic_experiences")
public class AcademicExpResource {

    @Autowired
    public AcademicExpService service;

    @GetMapping
    public ResponseEntity<List<AcademicExp>> findAll() {
        List<AcademicExp> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AcademicExp> findById(@PathVariable String id) {
        AcademicExp obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<AcademicExp> insert(@RequestBody AcademicExp obj) {
        obj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AcademicExp> update(@PathVariable String id, @RequestBody AcademicExp obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

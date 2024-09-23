package com.brunosenigalha.curriculumMongoDb.resources;

import com.brunosenigalha.curriculumMongoDb.entities.AcademicExpEntity;
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
    public ResponseEntity<List<AcademicExpEntity>> findAll() {
        List<AcademicExpEntity> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AcademicExpEntity> findById(@PathVariable String id) {
        AcademicExpEntity obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<AcademicExpEntity> insert(@RequestBody AcademicExpEntity obj) {
        obj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AcademicExpEntity> update(@PathVariable String id, @RequestBody AcademicExpEntity obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

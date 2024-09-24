package com.brunosenigalha.curriculumMongoDb.resources;

import com.brunosenigalha.curriculumMongoDb.dto.request.LanguageRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.LanguageEntity;
import com.brunosenigalha.curriculumMongoDb.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/languages")
public class LanguageResource {

    @Autowired
    public LanguageService service;

    @GetMapping
    public ResponseEntity<List<LanguageEntity>> findAll() {
        List<LanguageEntity> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LanguageEntity> findById(@PathVariable String id) {
        LanguageEntity obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<LanguageEntity> insert(@RequestBody LanguageRequestDTO objDTO) {
        LanguageEntity entity = service.insert(objDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LanguageEntity> update(@PathVariable String id, @RequestBody LanguageRequestDTO objDTO) {
        LanguageEntity entity = service.update(id, objDTO);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

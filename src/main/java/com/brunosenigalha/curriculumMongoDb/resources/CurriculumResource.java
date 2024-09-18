package com.brunosenigalha.curriculumMongoDb.resources;

import com.brunosenigalha.curriculumMongoDb.entities.CurriculumEntity;
import com.brunosenigalha.curriculumMongoDb.services.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/curricula")
public class CurriculumResource {

    @Autowired
    private CurriculumService curriculumService;

    @GetMapping
    public ResponseEntity<List<CurriculumEntity>> findAll() {
        List<CurriculumEntity> list = curriculumService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CurriculumEntity> findById(@PathVariable String id) {
        CurriculumEntity obj = curriculumService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<CurriculumEntity> insert(@RequestBody CurriculumEntity obj) {
        obj = curriculumService.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CurriculumEntity> update(@PathVariable String id, @RequestBody CurriculumEntity obj){
        CurriculumEntity entity = curriculumService.update(id, obj);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        curriculumService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

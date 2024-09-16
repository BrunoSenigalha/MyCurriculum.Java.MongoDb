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
    public CurriculumService service;

    @GetMapping
    public ResponseEntity<List<CurriculumEntity>> findAll() {
        List<CurriculumEntity> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CurriculumEntity> findById(@PathVariable String id) {
        CurriculumEntity obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }
    //    @PostMapping
//    public ResponseEntity<Curriculum> insert(@RequestBody Curriculum obj){
//        obj = service.insert(obj);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).body(obj);
//    }
    @PostMapping
    public ResponseEntity<CurriculumEntity> insert(@RequestBody CurriculumEntity obj) {
        obj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CurriculumEntity> update(@PathVariable String id, @RequestBody CurriculumEntity obj){
        CurriculumEntity entity = service.update(id, obj);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

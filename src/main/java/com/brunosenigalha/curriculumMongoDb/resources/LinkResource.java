package com.brunosenigalha.curriculumMongoDb.resources;

import com.brunosenigalha.curriculumMongoDb.dto.request.LinkRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.LinkEntity;
import com.brunosenigalha.curriculumMongoDb.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/links")
public class LinkResource {

    @Autowired
    public LinkService service;

    @GetMapping
    public ResponseEntity<List<LinkEntity>> findAll() {
        List<LinkEntity> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<LinkEntity> insert(@RequestBody LinkRequestDTO objDTO) {
        LinkEntity entity = service.insert(objDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LinkEntity> update(@PathVariable String id, @RequestBody LinkRequestDTO objDTO) {
        LinkEntity entity = service.update(id, objDTO);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

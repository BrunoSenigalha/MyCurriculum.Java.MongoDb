package com.brunosenigalha.curriculumMongoDb.resources;

import com.brunosenigalha.curriculumMongoDb.dto.request.ToolRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.ToolEntity;
import com.brunosenigalha.curriculumMongoDb.services.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tools")
public class ToolResource {

    @Autowired
    private ToolService service;

    @GetMapping
    public ResponseEntity<List<ToolEntity>> findAll() {
        List<ToolEntity> entities = service.findAll();
        return ResponseEntity.ok(entities);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToolEntity> findById(@PathVariable String id) {
        ToolEntity entity = service.findById(id);
        return ResponseEntity.ok(entity);
    }

    @GetMapping(value = "/namesearch")
    private ResponseEntity<ToolEntity> findByName(@RequestParam("name") String name) {
        ToolEntity entity = service.findByName(name);
        return ResponseEntity.ok(entity);
    }

    @PostMapping
    private ResponseEntity<ToolEntity> insert(@RequestBody ToolRequestDTO objDTO) {
        ToolEntity entity = service.insert(objDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

}

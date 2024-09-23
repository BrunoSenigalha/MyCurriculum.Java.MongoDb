package com.brunosenigalha.curriculumMongoDb.resources;

import com.brunosenigalha.curriculumMongoDb.dto.request.CourseRequestDTO;
import com.brunosenigalha.curriculumMongoDb.entities.CourseEntity;
import com.brunosenigalha.curriculumMongoDb.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseResource {

    @Autowired
    public CourseService service;

    @GetMapping
    public ResponseEntity<List<CourseEntity>> findAll() {
        List<CourseEntity> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseEntity> findById(@PathVariable String id) {
        CourseEntity obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<CourseEntity> insert(@RequestBody CourseRequestDTO objDTO) {
        CourseEntity entity = service.insert(objDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CourseEntity> update(@PathVariable String id, @RequestBody CourseRequestDTO objDTO){
        CourseEntity entity = service.update(id, objDTO);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

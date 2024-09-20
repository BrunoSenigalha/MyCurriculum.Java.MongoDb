package com.brunosenigalha.curriculumMongoDb.resources;

import com.brunosenigalha.curriculumMongoDb.converters.ConverterData;
import com.brunosenigalha.curriculumMongoDb.dto.request.CurriculumRequestDTO;
import com.brunosenigalha.curriculumMongoDb.dto.response.CurriculumResponseDTO;
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

    @Autowired
    private ConverterData converterData;

    @GetMapping
    public ResponseEntity<List<CurriculumResponseDTO>> findAll() {
        List<CurriculumResponseDTO> list = curriculumService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<CurriculumEntity> findById(@PathVariable String id) {
        CurriculumEntity obj = curriculumService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/emailsearch")
    public ResponseEntity<CurriculumEntity> findCurriculumByEmail(@RequestParam("email") String email) {
        CurriculumEntity entity = curriculumService.findByEmail(email);
        return ResponseEntity.ok(entity);

    }

    @PostMapping
    public ResponseEntity<CurriculumResponseDTO> insert(@RequestBody CurriculumRequestDTO objDTO) {
        CurriculumResponseDTO obj = curriculumService.insertCurriculum(objDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CurriculumEntity> update(@PathVariable String id, @RequestBody CurriculumRequestDTO objDTO) {
        CurriculumEntity entity = converterData.forCurriculumEntity(objDTO);
        entity.setId(id);
        entity = curriculumService.update(entity);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        curriculumService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.brunosenigalha.curriculumMongoDb.repositories;

import com.brunosenigalha.curriculumMongoDb.entities.ToolEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository extends MongoRepository<ToolEntity, String> {
}

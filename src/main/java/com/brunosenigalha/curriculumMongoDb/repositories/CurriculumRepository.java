package com.brunosenigalha.curriculumMongoDb.repositories;

import com.brunosenigalha.curriculumMongoDb.entities.Curriculum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository extends MongoRepository<Curriculum, String> {
}

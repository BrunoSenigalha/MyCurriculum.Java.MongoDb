package com.brunosenigalha.curriculumMongoDb.repositories;

import com.brunosenigalha.curriculumMongoDb.entities.AcademicExp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicExpRepository extends MongoRepository<AcademicExp, String> {
}

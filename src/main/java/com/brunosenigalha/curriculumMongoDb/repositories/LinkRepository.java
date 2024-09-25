package com.brunosenigalha.curriculumMongoDb.repositories;

import com.brunosenigalha.curriculumMongoDb.entities.LinkEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends MongoRepository<LinkEntity, String> {
}

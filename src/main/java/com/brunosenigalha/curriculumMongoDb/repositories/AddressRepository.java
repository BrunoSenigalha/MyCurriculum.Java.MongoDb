package com.brunosenigalha.curriculumMongoDb.repositories;

import com.brunosenigalha.curriculumMongoDb.entities.AddressEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<AddressEntity, String> {
}

package com.example.btaptonghop.Repository;

import com.example.btaptonghop.Model.MyMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyMongoRepository extends MongoRepository<MyMongoEntity,String> {
}

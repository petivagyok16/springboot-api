package com.peterp.springapi.repository;

import com.peterp.springapi.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("mongoDb")
public interface StudentRepository extends MongoRepository<Student, String> {

}

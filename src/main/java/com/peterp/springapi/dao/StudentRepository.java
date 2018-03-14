package com.peterp.springapi.dao;

import com.peterp.springapi.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("mongoDb")
public interface StudentRepository extends MongoRepository<Student, String> {

	Student findStudentById(UUID studentId);

	List<Student> listAllStudent();

}

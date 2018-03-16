package com.peterp.springapi.dao;

import com.peterp.springapi.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("mongoDb")
public interface StudentRepository extends MongoRepository<Student, String> {

		Student getStudentById(UUID studentId);

	//	List<Student> listAllStudent();
}

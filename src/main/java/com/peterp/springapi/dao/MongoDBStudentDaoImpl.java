package com.peterp.springapi.dao;

import com.peterp.springapi.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("mongoDb")
public class MongoDBStudentDaoImpl implements StudentDao {

//	private final MongoDbTemplate mongoDbTemplate;

	@Override
	public int insertNewStudent(Student student) {
		return 0;
	}

	@Override
	public Student selectStudentById(UUID studentId) {
		return null;
	}

	@Override
	public List<Student> selectAllStudents() {
		return null;
	}

	@Override
	public int updateStudentById(UUID studentId, Student newStudent) {
		return 0;
	}

	@Override
	public int deleteStudentById(UUID studentId) {
		return 0;
	}
}

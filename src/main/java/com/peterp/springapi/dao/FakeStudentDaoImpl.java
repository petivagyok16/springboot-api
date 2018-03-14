package com.peterp.springapi.dao;

import com.peterp.springapi.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
public class FakeStudentDaoImpl implements StudentDao {

	private final Map<UUID, Student> database;

	public FakeStudentDaoImpl() {
		this.database = new HashMap<>();

		UUID studentId = UUID.randomUUID();
		database.put(studentId, new Student(studentId, "peter", "pal", "biology"));
	}

	@Override
	public int insertNewStudent(Student student) {
		this.database.put(student.getId(), student);
		return 0;
	}

	@Override
	public Student selectStudentById(UUID studentId) {
		return this.database.get(studentId);
	}

	@Override
	public List<Student> selectAllStudents() {
		return new ArrayList<>(this.database.values());
	}

	@Override
	public int updateStudentById(UUID studentId, Student newStudent) {
		this.database.put(studentId, newStudent);
		return 1;
	}

	@Override
	public int deleteStudentById(UUID studentId) {
		this.database.remove(studentId);
		return 1;
	}
}

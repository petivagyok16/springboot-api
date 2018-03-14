package com.peterp.springapi.dao;

import com.peterp.springapi.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {

	int insertNewStudent(Student student);

	Student selectStudentById(UUID studentId);

	List<Student> selectAllStudents();

	int updateStudentById(UUID studentId, Student newStudent);

	int deleteStudentById(UUID studentId);
}

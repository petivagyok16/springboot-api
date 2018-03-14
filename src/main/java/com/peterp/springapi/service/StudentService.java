package com.peterp.springapi.service;

import com.peterp.springapi.dao.StudentDao;
import com.peterp.springapi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service("studentService")
public class StudentService {

	private final StudentDao studentDao;

	@Autowired
	public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	public int persistNewStudent(UUID studentId, Student student) {
		UUID studentUid = studentId == null ? UUID.randomUUID() : studentId;
		student.setId(studentUid);
		return this.studentDao.insertNewStudent(student);
	}

	public Student getStudentById(UUID studentId) {
		return this.studentDao.selectStudentById(studentId);
	}

	public List<Student> getAllStudents() {
		return this.studentDao.selectAllStudents();
	}

	public int updateStudentById(UUID studentId, Student newStudent) {
		return this.studentDao.updateStudentById(studentId, newStudent);
	}

	public int deleteStudentById(UUID studentId) {
		Student student = getStudentById(studentId);

		if (student == null) {
			System.out.println("Cannot find student. Handle error.");
			return 0;

		} else {
			return this.studentDao.deleteStudentById(studentId);
		}

	}

}

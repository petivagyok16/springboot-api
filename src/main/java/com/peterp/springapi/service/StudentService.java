package com.peterp.springapi.service;

import com.peterp.springapi.repository.StudentRepository;
import com.peterp.springapi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("studentService")
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}


	public Student addNewStudent(Student student) {
		return this.studentRepository.save(student);
	}

	public Optional<Student> getStudentById(String studentId) {
		return this.studentRepository.findById(studentId);
	}

	public List<Student> getAllStudents() {
		return this.studentRepository.findAll();
	}

	public int updateStudentById(String studentId, Student newStudent) {
//		return this.studentDao.updateStudentById(studentId, newStudent);
		Optional <Student> student = this.getStudentById(studentId);
//		return this.studentRepository.updateStudentById(studentId, newStudent);
		return 1; // TODO: start here
	}

	public int deleteStudentById(String studentId) {
		Optional<Student> student = getStudentById(studentId);

		if (student == null) {
			System.out.println("Cannot find student. Handle error.");
			return 0;

		} else {
//			return this.studentDao.deleteStudentById(studentId);
			return 0;
		}

	}

}

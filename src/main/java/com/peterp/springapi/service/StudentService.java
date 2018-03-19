package com.peterp.springapi.service;

import com.peterp.springapi.exceptions.StudentNotFoundException;
import com.peterp.springapi.repository.StudentRepository;
import com.peterp.springapi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("studentService")
public class StudentService {

	@Autowired private StudentRepository studentRepository;


	public Student addNewStudent(Student student) {
		return this.studentRepository.save(student);
	}

	public Student getStudentById(String studentId) {
		Optional<Student> student = studentRepository.findById(studentId);

		if (student.isPresent()) {
			return student.get();
		} else {
			throw this.studentNotFound(studentId);
		}
	}

	public List<Student> getAllStudents() {
		return this.studentRepository.findAll();
	}

	public Student updateStudentById(String studentId, Student newStudent) {
		Optional<Student> student = studentRepository.findById(studentId);

		if (student.isPresent()) {
			student.get().setCourse(newStudent.getCourse());
			student.get().setFirstName(newStudent.getFirstName());
			student.get().setLastName(newStudent.getLastName());

			return this.studentRepository.save(student.get());
		} else {
			throw this.studentNotFound(studentId);
		}

	}

	public void deleteStudentById(String studentId) {
		Student student = this.getStudentById(studentId);
		this.studentRepository.delete(student);
	}

	private StudentNotFoundException studentNotFound(String studentId) {
		return new StudentNotFoundException("Student is not found with id: " + studentId);
	}

}

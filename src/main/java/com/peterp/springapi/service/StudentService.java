package com.peterp.springapi.service;

import com.peterp.springapi.exceptions.StudentNotFoundException;
import com.peterp.springapi.repository.StudentRepository;
import com.peterp.springapi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("studentService")
public class StudentService {

	@Autowired private StudentRepository studentRepository;
	@Autowired private MongoTemplate mongoTemplate;


	public Student addNewStudent(Student student) {
		return this.studentRepository.save(student);
	}

	public Student getStudentById(String studentId) {
		Student student = mongoTemplate.findById(studentId, Student.class);

		if (student != null) {
			return student;
		} else {
			throw new StudentNotFoundException("Student is not found with id: " + studentId);
		}
	}

	public List<Student> getAllStudents() {
		return this.studentRepository.findAll();
	}

	public Student updateStudentById(String studentId, Student newStudent) {
		Student student = mongoTemplate.findById(studentId, Student.class);
//		Optional<Student> student = studentRepository.findById(studentId); --> try this. Wont work because of Option <Student>. What can i do to make it work?

		if (student != null) {
			student.setCourse(newStudent.getCourse());
			student.setFirstName(newStudent.getFirstName());
			student.setLastName(newStudent.getLastName());

			return this.studentRepository.save(student);
		} else {
			throw new StudentNotFoundException("Student is not found with id: " + studentId);
		}

	}

	public void deleteStudentById(String studentId) {
		Student student = this.getStudentById(studentId);
		if (student != null) {
			this.studentRepository.delete(student);
		} else {
			throw new StudentNotFoundException("Student is not found with id: " + studentId);
		}
	}

}

package com.peterp.springapi.controller;

import com.peterp.springapi.model.Student;
import com.peterp.springapi.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE
	)
	public List<Student> getAllStudents() {
		return this.studentService.getAllStudents();
	}

	@RequestMapping(
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE,
					path = "{studentId}"
	)
	public Student getStudentById(@PathVariable("studentId") String studentId) {
		return this.studentService.getStudentById(studentId);
	}

	@RequestMapping(
					method = RequestMethod.POST,
					produces = MediaType.APPLICATION_JSON_VALUE
	)
	@ResponseStatus(HttpStatus.CREATED)
	public void insertNewStudent(@RequestBody Student student) {
		this.studentService.addNewStudent(student);
	}

	@RequestMapping(
					method = RequestMethod.PUT,
					produces = MediaType.APPLICATION_JSON_VALUE,
					path = "{studentId}"
	)
	@ResponseStatus(HttpStatus.OK)
	public Student updateStudent(@RequestBody Student student, @PathVariable("studentId") String studentId) {
		return this.studentService.updateStudentById(studentId, student);
	}

	@RequestMapping(
					method = RequestMethod.DELETE,
					produces = MediaType.APPLICATION_JSON_VALUE,
					path = "{studentId}"
	)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteStudentById(@PathVariable("studentId") String studentId) {
		this.studentService.deleteStudentById(studentId);
	}
}

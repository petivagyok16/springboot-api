package com.peterp.springapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Student {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String course;

	public Student(
					@JsonProperty("id") String id,
					@JsonProperty("firstName") String firstName,
					@JsonProperty("lastName") String lastName,
					@JsonProperty("course") String course
	) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCourse() {
		return course;
	}

	@Override
	public String toString() {
		return String.format(
						"Student[id=%s, firstName='%s', lastName='%s']",
						id, firstName, lastName);
	}
}

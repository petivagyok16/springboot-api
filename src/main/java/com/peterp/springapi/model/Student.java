package com.peterp.springapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Student {

	@Id
	public UUID id;

	private final String firstName;
	private final String lastName;
	private final String course;

	public Student(
					@JsonProperty("id") UUID id,
					@JsonProperty("firstName") String firstName,
					@JsonProperty("lastName") String lastName,
					@JsonProperty("course") String course
	) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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

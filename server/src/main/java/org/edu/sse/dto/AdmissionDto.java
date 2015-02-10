package org.edu.sse.dto;

import java.sql.Date;
import java.util.List;

import org.edu.sse.model.ClassDetail;

public class AdmissionDto {

	private String surname;

	private String firstName;

	private String lastName;

	private Date dateOfBirth;

	private String fatherName;

	private String motherName;

	private String dateOfJoin;
	
	private List<ClassDetail> classDetails;
 
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public List<ClassDetail> getClassDetails() {
		return classDetails;
	}

	public void setClassDetails(List<ClassDetail> classDetails) {
		this.classDetails = classDetails;
	}

	
}

package org.edu.sse.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.edu.sse.entityconversion.ClassDetailEntityConversion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@NamedQueries({ @NamedQuery(name = Admission.FINDBY_ADMISSIONID_NQUERY, query = "from Admission a where a.admissionId = :admissionId") })
@Entity
@Table(name = "ADMISSION")
@JsonInclude(Include.NON_NULL)
public class Admission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5611879037454640310L;

	public static final String FINDBY_ADMISSIONID_NQUERY = "findByAdmissionId";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;

	@Column(name = "ADMISSIONID")
	private String admissionId;

	@Column(name = "SURNAME")
	private String surname;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "DOB")
	private Date dateOfBirth;

	@Column(name = "FATHERNAME")
	private String fatherName;

	@Column(name = "MOTHERNAME")
	private String motherName;

	@Column(name = "DOJ")
	private Date dateOfJoin;

	@OneToOne
	@JoinColumn(name = "ADMITTEDCLASSFID")
	@JsonDeserialize(using = ClassDetailEntityConversion.class)
	private ClassDetail admittedClass;

	@Column(name = "CASTE")
	private String caste;

	@Column(name = "CURRENTSTATUS")
	private String currentStatus;

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(String admissionId) {
		this.admissionId = admissionId;
	}

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public Date getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public ClassDetail getAdmittedClass() {
		return admittedClass;
	}

	public void setAdmittedClass(ClassDetail admittedClass) {
		this.admittedClass = admittedClass;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

}

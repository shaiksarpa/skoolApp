package org.edu.sse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -763308695544403985L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long pid;


	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ADMISSIONFID")
	private Admission admission;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PRESENTCLASSFID")
	private ClassDetail classDetail;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ADDRESSFID")
	private Address address;

	
	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	public ClassDetail getClassDetail() {
		return classDetail;
	}

	public void setClassDetail(ClassDetail classDetail) {
		this.classDetail = classDetail;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}

package org.edu.sse.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLASSDETAIL")
public class ClassDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1303115159876135130L;

	@Id
	@Column(name="PID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long pid; 
	
	@Column(name="CLASS")
	private String className;
	
	@Column(name  = "DESCRIPTION")
	private String description;
	 
	@Column(name = "MEDIUM") 
	private String medium;
	
	@Column(name = "TUTIONFEE")
	private double tutionFee;

	
	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public double getTutionFee() {
		return tutionFee;
	}

	public void setTutionFee(double tutionFee) {
		this.tutionFee = tutionFee;
	}

	
	
}

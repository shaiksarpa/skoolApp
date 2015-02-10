package org.edu.sse.dto;

import java.io.Serializable;

public class StudentCSV implements Serializable{
	
	private String admissionNo;
	private String name;
	private String className;
	private String phone;
	private String village;

	public String getAdmissionNo() {
		return admissionNo;
	}

	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	@Override
	public String toString() {
		return "StudentCSV [admissionNo=" + admissionNo + ", name=" + name
				+ ", className=" + className + ", phone=" + phone
				+ ", village=" + village + "]";
	}

}

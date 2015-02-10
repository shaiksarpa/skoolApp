package org.edu.sse.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5707667394285008079L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PID")
	private long pid;

	@Column(name = "ADDRESSLINE1")
	private String addressLine1;

	@Column(name = "ADDRESSLINE2")
	private String addressLine2;

	@Column(name = "VILLAGE")
	private String village;

	@Column(name = "MANDAL")
	private String mandal;

	@Column(name = "PHONE")
	private long phone;

	@Column(name = "ALTPHONE")
	private long altPhone;

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getMandal() {
		return mandal;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public long getAltPhone() {
		return altPhone;
	}

	public void setAltPhone(long altPhone) {
		this.altPhone = altPhone;
	}


}

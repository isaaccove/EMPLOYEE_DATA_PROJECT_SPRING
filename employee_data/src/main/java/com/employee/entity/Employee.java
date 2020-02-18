package com.employee.entity;
import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")

public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="date_of_Birth")
	private Date dateOfBirth;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phonenumber")
	private String phoneNUmber;

	
	
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public Employee(String firstname, String lastname, Date dateOfBirth, String email, String phoneNUmber) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phoneNUmber = phoneNUmber;
	}
	
	

	public Employee() {
		super();
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNUmber() {
		return phoneNUmber;
	}

	public void setPhoneNUmber(String phoneNUmber) {
		this.phoneNUmber = phoneNUmber;
	}

	
}

package model;

import java.time.LocalDate;

public class Employee {
	private int empNo;
	private LocalDate birthDate;
	private String firstName;
	private String lastName;
	private String gender;
	private LocalDate hireDate;

	public Employee(int empNo, LocalDate birthDate, String firstName, String lastName, String gender,
			LocalDate hireDate) {
		this.empNo = empNo;
		this.birthDate = birthDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.hireDate = hireDate;
	}

	// Getters and setters
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	// ToString method
	@Override
	public String toString() {
		return "Employee{" + "empNo=" + empNo + ", birthDate=" + birthDate + ", firstName='" + firstName + '\''
				+ ", lastName='" + lastName + '\'' + ", gender='" + gender + '\'' + ", hireDate=" + hireDate + '}';
	}

}// FINAL CLASS
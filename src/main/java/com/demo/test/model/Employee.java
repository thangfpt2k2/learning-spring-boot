package com.demo.test.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
		name = "tbl_employee",
		uniqueConstraints = {
				@UniqueConstraint(name = "employee_phone_unique", columnNames = "phone")
		}
)
public class Employee {

	@Id
	@SequenceGenerator(
			name = "employee_sequence",
			sequenceName = "employee_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = SEQUENCE,
			generator = "employee_sequence"
	)
	@Column(
			name = "id",
			updatable = false
	)
	private Long id;
	
	@Column(
			name = "full_name",
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String fullname;
	
	@Column(
			name = "birth_date",
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String birthdate;
	
	@Column(
			name = "gender",
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String gender;
	
	@Column(
			name = "phone",
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String phone;
	
	@Column(
			name = "address",
			columnDefinition = "TEXT"
	)
	private String address;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [fullname=" + fullname + ", birthdate=" + birthdate + ", gender=" + gender + ", phone=" + phone
				+ ", address=" + address + "]";
	}
}

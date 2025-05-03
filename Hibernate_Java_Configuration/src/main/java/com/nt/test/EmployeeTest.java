package com.nt.test;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class EmployeeTest {

	@Id
	private int id;
	public EmployeeTest(int id, String nameString) {
		this.id = id;
		this.nameString = nameString;
	}
	private String nameString;
}

package com.velox.Hibernate_Java_Based_Configuration;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
public class EmployeeTest {
	
	@Id
    private int id;
    public EmployeeTest(int id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}
	private String name;
    private String department;

}
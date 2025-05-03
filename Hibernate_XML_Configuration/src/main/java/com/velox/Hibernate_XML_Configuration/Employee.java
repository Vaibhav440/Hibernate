package com.velox.Hibernate_XML_Configuration;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
    private int id;
    public Employee(int id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}
	private String name;
    private String department;

}

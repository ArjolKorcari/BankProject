package com.example.BankProjekt.Programmer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.example.BankProjekt.Bank.Bank;

import jakarta.validation.constraints.Size;


public class Programmer {
	
	
	
	
	
	
	
	
	
	

	public Programmer(Bank bankName, Integer id, String name, String surname, String description, Integer salary,
			String tasks,int yearsOfEmployee) {
		super();
		this.bankName = bankName;
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.description = description;
		this.salary = salary;
		this.tasks = tasks;
		this.yearsOfEmployee=yearsOfEmployee;
	}
	
	
	private Bank bankName;
	private Integer id;
	@Size(min = 3, message = "Enter atleast 3 characters")
	private String name;
	@Size(min=3, message = "Enter atleast 3 characters")
	private String surname;
	@Size(min=10, message = "Enter atleast 10 characters")
	private String description;
	private Integer salary;
	@Size(min=7, message = "Enter atleast 7 characters")
	private String tasks;
	private int yearsOfEmployee;
	
	
	
	
	public Bank getBankName() {
		return bankName;
	}
	public void setBankName(Bank bankName) {
		this.bankName = bankName;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getTasks() {
		return tasks;
	}
	public void setTasks(String tasks) {
		this.tasks = tasks;
	}
	
	
	
	public int getYearsOfEmployee() {
		return yearsOfEmployee;
	}
	public void setYearsOfEmployee(int yearsOfEmployee) {
		this.yearsOfEmployee = yearsOfEmployee;
	}
	@Override
	public String toString() {
		return "Programmer [bankName=" + bankName + ", id=" + id + ", name=" + name + ", surname=" + surname
				+ ", description=" + description + ", salary=" + salary + ", tasks=" + tasks + "]";
	}
	
	
	
	

}

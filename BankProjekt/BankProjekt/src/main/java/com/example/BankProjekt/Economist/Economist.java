package com.example.BankProjekt.Economist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.example.BankProjekt.Bank.Bank;

import jakarta.validation.constraints.Size;


public class Economist {
	
	

	
	
	public Economist(Bank bankName, Integer id, @Size(min = 3, message = "Enter atleast 3 characters") String name,
			@Size(min = 3, message = "Enter atleast 3 characters") String surname, Integer salary,
			int yearsOfEmployee) {
		super();
		this.bankName = bankName;
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.yearsOfEmployee = yearsOfEmployee;
	}
	private Bank bankName;
	private Integer id;
	@Size(min = 3, message = "Enter atleast 3 characters")
	private String name;
	@Size(min=3, message = "Enter atleast 3 characters")
	private String surname;
	private Integer salary;
	private int yearsOfEmployee;
	public Bank getBankName() {
		return bankName;
	}
	public void setBankName(Bank bankName) {
		this.bankName = bankName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public int getYearsOfEmployee() {
		return yearsOfEmployee;
	}
	public void setYearsOfEmployee(int yearsOfEmployee) {
		this.yearsOfEmployee = yearsOfEmployee;
	}
	@Override
	public String toString() {
		return "Economist [bankName=" + bankName + ", id=" + id + ", name=" + name + ", surname=" + surname
				+ ", salary=" + salary + ", yearsOfEmployee=" + yearsOfEmployee + "]";
	}
	
	
	
	
	
	
	
	

}

package com.example.BankProjekt.Bank;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.example.BankProjekt.Programmer.Programmer;

public class Bank {
	
	
	
	public Bank(String name) {
		this.name=name;
	}
	
	
	private String name;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	

}

package com.example.BankProjekt.Programmer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.BankProjekt.Bank.Bank;

import jakarta.validation.Valid;


@Service
public class ProgrammerServise {
	
	
	
	private static List<Programmer> programmers= new ArrayList<Programmer>();
	private static  int programmersCounter=0;
	
	static {
		
		programmers.add(new Programmer(new Bank("Raiffasen"), ++programmersCounter, "Arjol", "Korcari",
				"Java Programmer", 10000, "WEB-BACKEND",5));
		programmers.add(new Programmer(new Bank("Raiffasen"), ++programmersCounter, "Albi", "Bylykbashi",
				"C++ Programmer", 10000, "GAMING",3));
		programmers.add(new Programmer(new Bank("Raiffasen"), ++programmersCounter, "Anxhelo", "Kermezi",
				"JavaScript Programmer", 10000, "WEB-FRONTEND",1));
		
			
	}
	
	// Method to find programmers by bank name
    public static List<Programmer> findByBankName(String bankName) {
        List<Programmer> result = new ArrayList<>();
        for (Programmer programmer : programmers) {
            if (programmer.getBankName().getName().equalsIgnoreCase(bankName)) {
                result.add(programmer);
            }
        }
        return result;
    }
    public void addProgrammer(Bank bankName, String name , String surname, String description, 
    		int salary,String tasks, int yearsOfEmoloyee) {
    	Programmer programmer= new Programmer(bankName, ++programmersCounter,
    			name, surname, description,salary , tasks, yearsOfEmoloyee);
    	programmers.add(programmer);
    	
    }
    
    
    public void deleteById(int id) {
    	Predicate<? super Programmer>predicate =programmer->
    	programmer.getId()==id;
    	programmers.removeIf(predicate);
    }
    
    public Programmer findById(int id) {
    	for(Programmer programmer:programmers) {
    		if(programmer.getId()==id) {
    			return programmer;
    		}
    	}
    	return null;
    }
    public void updateProgrammer(@Valid Programmer programmer) {
    	deleteById(programmer.getId());
    	programmers.add(programmer);
    }
    public double calculateBonus(int salary, int yearsOfEmployee) {
     if(yearsOfEmployee<2) {
    	 return salary*0.02;
     }
     if(yearsOfEmployee>2&&yearsOfEmployee<5) {
    	 return salary*0.1;
     }
     return salary*0.3;
    }
    
    
   


}

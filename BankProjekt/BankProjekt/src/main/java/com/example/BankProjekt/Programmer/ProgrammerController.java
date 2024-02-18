package com.example.BankProjekt.Programmer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.BankProjekt.Bank.Bank;


import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class ProgrammerController {
	
	private ProgrammerServise programmerServise;
	private Programmer programmer;

	public ProgrammerController(ProgrammerServise programmerServise) {
		super();
		this.programmerServise = programmerServise;
	}
	
	@RequestMapping("list-programmers")
	public String listAllProgrammers (ModelMap model) {
		String username= (String)model.get("name");
		List<Programmer> programmers= (List<Programmer>) programmerServise.findByBankName("Raiffasen");
		model.addAttribute("programmers", programmers);
		return "listProgrammers";
		
	}
	
	@RequestMapping(value = "add-programmer",method = RequestMethod.GET)
	 public String showNewProgrammerPage(ModelMap model ) {
		String username=(String)model.get("name");
		Programmer programmer= new Programmer(new Bank(username), 0, "", "", "", 0, "",0);
		model.put("programmer", programmer);
		return "programmer";
	}
	
	@RequestMapping(value = "add-programmer",method=RequestMethod.POST)
	public String addNewProgrammer(ModelMap model, @Valid Programmer programmer,BindingResult result) {
		if(result.hasErrors()) {
			return "programmer";
			
		}
		String username =(String )model.get("name");
		programmerServise.addProgrammer(new Bank(username), programmer.getName(), programmer.getSurname(),
				programmer.getDescription(), programmer.getSalary(), programmer.getTasks(),programmer.getYearsOfEmployee());
		return "redirect:list-programmers";
	}
	
	
	
	@RequestMapping(value="update-programmer",method=RequestMethod.GET )
	public String showUpdatedProgrammerPage(@RequestParam int id, ModelMap model) {
	  Programmer programmer= programmerServise.findById(id);
		
		model.addAttribute("programmer",programmer);
		return "programmer";	
		
	}
	
	
	@RequestMapping(value="update-programmer", method=RequestMethod.POST)
	public String updateProgrammer(ModelMap model, @Valid Programmer programmer, BindingResult result) {
		if(result.hasErrors()) {
			return "programmer";
		}
		String username= (String) model.get("name");
		programmer.setBankName(new Bank(username));
		programmerServise.updateProgrammer(programmer);
		return "redirect:list-programmers";
		
	}
	
	@RequestMapping("delete-programmer")
	public String deleteProgrammer(@RequestParam int id) {
		programmerServise.deleteById(id);
		return "redirect:list-programmers";
	}
	
	@RequestMapping("calculate-bonus")
	public String calculateProgrammerBonus(@RequestParam int id, ModelMap model) {
		Programmer programmer= programmerServise.findById(id);
		double bonus=programmerServise.calculateBonus(programmer.getSalary(),programmer.getYearsOfEmployee());
		model.addAttribute("bonus",bonus);
		return "bonus";	
	}
	
	
	
	
	
	
	

	
	
	
	

}

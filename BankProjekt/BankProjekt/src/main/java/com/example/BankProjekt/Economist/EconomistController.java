package com.example.BankProjekt.Economist;

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
public class EconomistController {
	
	private EconomistServise economistServise;
	
	public EconomistController(EconomistServise programmerServise) {
		super();
		this.economistServise = programmerServise;
	}
	
	@RequestMapping("list-economists")
	public String listAllEconomists (ModelMap model) {
		String username= (String)model.get("name");
		List<Economist> economists= (List<Economist>) economistServise.findByBankName("Raiffasen");
		model.addAttribute("economists", economists);
		return "listEconomists";
		
	}
	
	@RequestMapping(value = "add-economist",method = RequestMethod.GET)
	 public String showNewEconomistPage(ModelMap model ) {
		String username=(String)model.get("name");
		Economist economist= new Economist(new Bank(username), 0, "", "", 0,0);
		model.put("economist", economist);
		return "economist";
	}
	
	@RequestMapping(value = "add-economist",method=RequestMethod.POST)
	public String addNewEconomist(ModelMap model, @Valid Economist economist,BindingResult result) {
		if(result.hasErrors()) {
			return "economist";
			
		}
		String username =(String )model.get("name");
		economistServise.addEconomist(new Bank(username),economist.getName(),economist.getSurname(),
				economist.getSalary(),economist.getYearsOfEmployee());
		return "redirect:list-economists";
	}
	
	
	
	@RequestMapping(value="update-economist",method=RequestMethod.GET )
	public String showUpdatedEconomistPage(@RequestParam int id, ModelMap model) {
	  Economist economist= economistServise.findById(id);
		
		model.addAttribute("economist",economist);
		return "economist";	
		
	}
	
	
	@RequestMapping(value="update-economist", method=RequestMethod.POST)
	public String updateEconomist(ModelMap model, @Valid Economist economist, BindingResult result) {
		if(result.hasErrors()) {
			return "economist";
		}
		String username= (String) model.get("name");
		economist.setBankName(new Bank(username));
		economistServise.updateEconomist(economist);
		return "redirect:list-economists";
		
	}
	
	@RequestMapping("delete-economist")
	public String deleteEconomist(@RequestParam int id) {
		economistServise.deleteById(id);
		return "redirect:list-economists";
	}
	
	@RequestMapping("calculate-economist-bonus")
	public String calculateEconomistBonus(@RequestParam int id, ModelMap model) {
		Economist economist= economistServise.findById(id);
		double bonus=economistServise.calculateBonus(economist.getSalary(),economist.getYearsOfEmployee());
		model.addAttribute("bonus",bonus);
		return "bonus";	
	}
	
	
	
	
	
	
	

	
	
	
	

}

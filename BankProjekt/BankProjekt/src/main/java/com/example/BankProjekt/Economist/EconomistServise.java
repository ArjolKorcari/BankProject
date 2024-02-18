package com.example.BankProjekt.Economist;

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
public class EconomistServise {

	private static List<Economist> economists = new ArrayList<Economist>();
	private static int economistsCounter = 0;

	static {

		economists.add(new Economist(new Bank("Raiffasen"), ++economistsCounter, "Anxhela", "Malaj", 300, 1));
		economists.add(new Economist(new Bank("Raiffasen"), ++economistsCounter, "Anjeza", "Ndreca", 400, 3));
		economists.add(new Economist(new Bank("Raiffasen"), ++economistsCounter, "Donika", "Qoshi", 350, 2));

	}

	// Method to find economists by bank name
	public static List<Economist> findByBankName(String bankName) {
		List<Economist> result = new ArrayList<>();
		for (Economist economist : economists) {
			if (economist.getBankName().getName().equalsIgnoreCase(bankName)) {
				result.add(economist);
			}
		}
		return result;
	}

	public void addEconomist(Bank bankName, String name, String surname, int salary, int yearsOfEmployee) {
		Economist economist = new Economist(bankName, ++economistsCounter, name, surname, salary, yearsOfEmployee);
		economists.add(economist);

	}

	public void deleteById(int id) {
		Predicate<? super Economist> predicate = economist -> economist.getId() == id;
		economists.removeIf(predicate);
	}

	public Economist findById(int id) {
		for (Economist economist : economists) {
			if (economist.getId() == id) {
				return economist;
			}
		}
		return null;
	}

	public void updateEconomist(@Valid Economist economist) {
		deleteById(economist.getId());
		economists.add(economist);
	}

	public double calculateBonus(int salary, int yearsOfEmployee) {
		if (yearsOfEmployee < 2) {
			return salary * 0.02;
		}
		if (yearsOfEmployee > 2 && yearsOfEmployee < 5) {
			return salary * 0.1;
		}
		return salary * 0.3;
	}

}

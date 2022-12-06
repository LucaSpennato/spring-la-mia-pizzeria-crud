package org.generation.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/drinks")
public class DrinkController {

	@Autowired
	private DrinkService ds;
	
	@GetMapping
	public String getHome(Model model) {
		
		List<Drink> drinks = ds.findAll();
		
		System.out.println(drinks);
		
		model.addAttribute("drinks", drinks);
		
		return "drinks";
	}
	
	@GetMapping("/create")
	public String addDrink(Model model) {
		
		model.addAttribute("drink" ,new Drink());
		
		return "create-drinks";
	}
	
	@PostMapping("/store")
	public String storeDrink(@Valid Drink d) {
		
		ds.save(d);
		
		return "redirect:/drinks";
	}
	
	@GetMapping("/edit/{id}")
	public String editDrink(@PathVariable("id") int id, Model model) {
		
		Optional<Drink> opt = ds.findDrinkById(id);
		
		Drink drink = opt.get();
		
		model.addAttribute("drink", drink);
		
		return "edit-drink";
	}
	
}

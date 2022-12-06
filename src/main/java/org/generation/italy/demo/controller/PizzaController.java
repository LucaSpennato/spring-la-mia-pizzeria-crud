package org.generation.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class PizzaController {
	
	@Autowired
	private PizzaService ps;
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Pizza> pizza = ps.findAll();
		model.addAttribute("pizza", pizza);
		return "home";
	}
	
	@GetMapping("/pizza/create")
	public String createPizza(Model model) {
		
		Pizza pizza = new Pizza();
		model.addAttribute("pizza", pizza);
		
		return "create";
	}
	
	@PostMapping("/pizza/create")
	public String storePizza(@Valid Pizza pizza) {
		
		ps.save(pizza);
		
		System.out.println(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/edit/{id}")
	public String editPizza(@PathVariable("id") int id, Model model) {
		
		Optional<Pizza> opt = ps.findPizzaById(id);
		Pizza pizza = opt.get();
		
		model.addAttribute("pizza", pizza);
		
		return "editpizza";
	}
	
	@PostMapping("/pizza/update")
	public String updatePizza(@Valid Pizza p) {
		
		
		ps.save(p);
		
		return "redirect:/";
	}
	
	@GetMapping("pizza/show/{id}")
	public String showPizza(@PathVariable("id") int id, Model model){
		
		Optional<Pizza> opt = ps.findPizzaById(id);
		Pizza pizza = opt.get();
		
		model.addAttribute("pizza", pizza);
		
		return "show";
	}
	
	@GetMapping("/pizza/delete/{id}")
	public String deletePizza(@PathVariable("id") int id) {
		
		ps.deletePizzaById(id);
		
		return "redirect:/";
	}
	
}

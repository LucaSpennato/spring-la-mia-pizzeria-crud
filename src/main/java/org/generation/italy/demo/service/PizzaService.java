package org.generation.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
	
	@Autowired
	private PizzaRepo P;
	
	public void save(Pizza pizza) {
		P.save(pizza);
	}
	
	public List<Pizza> findAll() {
		return P.findAll();
	}
	
	public Optional<Pizza> getPizzaById(int id) {
		return P.findById(id);
	}
	
	public void deletePizzaById(int id) {
		P.deleteById(id);
	}
}
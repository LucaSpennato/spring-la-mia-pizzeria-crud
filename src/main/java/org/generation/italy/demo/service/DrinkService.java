package org.generation.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.repo.DrinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {

	@Autowired
	private DrinkRepo p;
	
	
	public void save(Drink d) {
		p.save(d);
	}
	
	public List<Drink> findAll(){
		return p.findAll();
	}
	
	public Optional<Drink> findDrinkById(int id){
		return p.findById(id);
	}
	
	public void deleteDrink(Drink d) {
		p.delete(d);
	}
}

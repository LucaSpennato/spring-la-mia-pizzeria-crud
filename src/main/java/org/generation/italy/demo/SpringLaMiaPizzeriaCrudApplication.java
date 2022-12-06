package org.generation.italy.demo;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.DrinkService;
import org.generation.italy.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{
	
	@Autowired
	private PizzaService P;
	@Autowired
	private DrinkService d;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Pizza p1 = new Pizza("Margherita", "pizzapazza" , 5);
		Pizza p2 = new Pizza("Qualcosa", "descrizione carina" , 6);
		Pizza p3 = new Pizza("FourSeason", "descrizione carina il ritorno" , 7);
		Pizza p4 = new Pizza("FourSeason", "descrizione carina il ritorno" , 7);
		
		P.save(p1);
		P.save(p2);
		P.save(p3);
		P.save(p4);
		
		// Drinks 
		
		Drink d1 = new Drink("EINEKE", null, 3);
		Drink d2 = new Drink("DREKER", null, 3);
		Drink d3 = new Drink("TENNES", null, 5);
		
		d.save(d1);
		d.save(d2);
		d.save(d3);
	}

}

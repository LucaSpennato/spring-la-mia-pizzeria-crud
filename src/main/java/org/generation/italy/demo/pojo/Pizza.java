package org.generation.italy.demo.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	@Lob
	private String description;
	
	@Column
	private int price;
	
	public Pizza() { }
	
	public Pizza(String name, String description, int price ) {
		
		setName(name);
		setDescription(description);
		setPrice(price);
		
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getPrice() {
		return price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {

		
		return getId() + " - " + getName() + " " + getPrice() + "$"; 
	}
	
}

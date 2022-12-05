package org.generation.italy.demo.pojo;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message="name cannot be null")
	@Size(min=10, max=100, message="Name must be between 10 and 100 character")
	@Column(length=100)
	private String name;
	
	@Lob
	@Nullable
	@Size(max=20000)
	@Column(length=20000)
	private String description;
	
	@NotNull
	@Min(value=1)
	private Integer price;
	
	public Pizza() { }
	public Pizza(String name, String description, Integer price) {
		
		setName(name);
		setDescription(description);
		setPrice(price);
		
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Integer getPrice() {
		return price;
	}
	
	private void setId(Integer id) {
		this.id = id;
	}
	private void setName(String name) {
		this.name = name;
	}
	private void setDescription(String description) {
		this.description = description;
	}
	private void setPrice(Integer price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return getId() + " - " + getName() + " " + getPrice() + "$"; 
	}
	
}

package com.example.springmvc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName="products",type="_doc",shards=1)

public class Products {
	
	private String id;
	private String name;
	private String description;

	private long in_stock;
	private boolean is_active;
	private long price;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public long getIn_stock() {
		return in_stock;
	}
	public void setIn_stock(long in_stock) {
		this.in_stock = in_stock;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Products() {
	}
	
	
	
		

}
package com.example.Hotel_Management.entity;

import jakarta.persistence.*;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String location;

    private Double price;

    private String imgUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Hotel(int id, String name, String location, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", location=" + location + ", price=" + price + ", imgUrl="
				+ imgUrl + "]";
	}
    
    
	
}

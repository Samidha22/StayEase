package com.example.Hotel_Management.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;
    private String email;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int guests;
    private String hotelName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public int getGuests() {
		return guests;
	}
	public void setGuests(int guests) {
		this.guests = guests;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", fullName=" + fullName + ", email=" + email + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + ", guests=" + guests + ", hotelName=" + hotelName + "]";
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int id, String fullName, String email, LocalDate checkInDate, LocalDate checkOutDate, int guests,
			String hotelName) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.guests = guests;
		this.hotelName = hotelName;
	}

    
}

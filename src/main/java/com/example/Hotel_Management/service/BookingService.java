package com.example.Hotel_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hotel_Management.entity.Booking;
import com.example.Hotel_Management.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	
	

	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);		
	}
}

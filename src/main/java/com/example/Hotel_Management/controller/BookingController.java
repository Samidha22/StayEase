package com.example.Hotel_Management.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Hotel_Management.entity.Booking;
import com.example.Hotel_Management.service.BookingService;

@Controller  // ✅ Important: Add this annotation
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
    @GetMapping("/book")
    public String showBookingForm(Model model) {
        model.addAttribute("booking", new Booking());
        return "booking"; 
    }

    @PostMapping("/book")
    public String processBooking(@ModelAttribute Booking booking, Model model) {
    	bookingService.saveBooking(booking);
        model.addAttribute("message", "Booking Successful! We'll contact you soon.");
        return "confirmation"; 
    }
    
   
}

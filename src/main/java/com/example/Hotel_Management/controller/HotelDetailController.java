package com.example.Hotel_Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Hotel_Management.entity.Hotel;
import com.example.Hotel_Management.service.HotelService;

import java.util.Optional;

@Controller
public class HotelDetailController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotel/details/{id}")
    public String showHotelDetails(@PathVariable int id, Model model) {
        Optional<Hotel> hotel = hotelService.getHotelById(id);
        
        if (hotel.isPresent()) {
            model.addAttribute("hotel", hotel.get());
            return "hotelDetails"; 
        } else {
            return "redirect:/hotel"; 
        }
    }
}

package com.example.Hotel_Management.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Hotel_Management.entity.Hotel;
import com.example.Hotel_Management.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {
    
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "index";
    }

    @GetMapping("/add")
    public String addHotel(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "addHotel";
    }

    @PostMapping("/save")
    public String saveHotel(@ModelAttribute Hotel hotel) {
        hotelService.saveHotel(hotel);
        return "redirect:/hotel";
    }

    @GetMapping("/delete/{id}")
    public String deleteHotel(@PathVariable int id) {
        hotelService.deleteHotel(id);
        return "redirect:/hotel";
    }

    @GetMapping("/edit/{id}")
    public String showEditHotelForm(@PathVariable int id, Model model) {
        Optional<Hotel> hotel = hotelService.getHotelById(id);
        if (hotel.isPresent()) {
            model.addAttribute("hotel", hotel.get());
            return "edit-hotel"; 
        }
        return "redirect:/hotel";
    }

    @PostMapping("/update/{id}")
    public String updateHotel(@PathVariable int id, @ModelAttribute Hotel hotel) {
        hotel.setId(id);
        hotelService.saveHotel(hotel);
        return "redirect:/hotel";
    }

    @GetMapping("/search")
    public String searchHotels(@RequestParam("title") String title, Model model) {
        model.addAttribute("hotels", hotelService.searchHotelsByName(title));
        return "index"; 
    }
    
    @GetMapping("/location/{locationName}")
    public String getHotelsByLocation(@PathVariable String locationName, Model model) {
        model.addAttribute("hotels", hotelService.getHotelsByLocation(locationName));
        model.addAttribute("selectedCity", locationName);
        return "hotel-listing";  // This will load the same hotel listing page but filtered
    }

    
    @GetMapping("/about")
    public String aboutUs()
    {
    	return "about";
    }
    
    @GetMapping("/contact")
    public String contactPage() {
        return "contact"; 
    }
}

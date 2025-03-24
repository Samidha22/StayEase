package com.example.Hotel_Management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hotel_Management.entity.Hotel;
import com.example.Hotel_Management.repository.HotelRepository;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel saveHotel(Hotel hotel) { 
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(int id) {
        hotelRepository.deleteById(id);
    }

    public Optional<Hotel> getHotelById(int id) {
        return hotelRepository.findById(id);
    }

    public List<Hotel> searchHotelsByName(String title) {
        return hotelRepository.findByNameContainingIgnoreCase(title);
    }

    public List<Hotel> getHotelsByLocation(String location) {
        return hotelRepository.findByLocation(location);
	}
}

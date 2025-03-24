package com.example.Hotel_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hotel_Management.entity.Hotel;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByNameContainingIgnoreCase(String name);
    
    List<Hotel> findByLocation(String location);
   
}

package com.Book.GoCab.Repository;

import com.Book.GoCab.Model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Long> {
    List<Driver> findByAvailableTrueAndCurrentLocation(String currentLocation);
}

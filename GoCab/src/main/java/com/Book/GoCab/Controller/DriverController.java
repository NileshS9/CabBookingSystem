package com.Book.GoCab.Controller;

import com.Book.GoCab.Model.Driver;
import com.Book.GoCab.Repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;

    @PostMapping("/add")
    public ResponseEntity<Driver> addDriver(@RequestBody Driver driver){
        driver.setAvailable(true); //set available by default
        Driver saveddriver = driverRepository.save(driver);
        return new ResponseEntity<>(saveddriver, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }
}

package com.Book.GoCab.Controller;

import com.Book.GoCab.Model.Driver;
import com.Book.GoCab.Repository.DriverRepository;
import com.Book.GoCab.Service.DriverService;
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

    @Autowired
    private DriverService driverService;

    @GetMapping("/all")
    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<Driver> registerDriver(@RequestBody Driver driver){
        driver.setAvailable(true); //set available by default
        Driver savedDriver = driverService.registerDriver(driver);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDriver);
    }


}

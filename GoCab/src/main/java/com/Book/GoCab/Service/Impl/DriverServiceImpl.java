package com.Book.GoCab.Service.Impl;

import com.Book.GoCab.Model.Driver;
import com.Book.GoCab.Repository.DriverRepository;
import com.Book.GoCab.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl  implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Driver registerDriver(Driver driver) {
        driver.setAvailable(true); //by default available
        return driverRepository.save(driver);
    }
}

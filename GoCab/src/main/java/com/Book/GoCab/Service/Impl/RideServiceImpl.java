package com.Book.GoCab.Service.Impl;

import com.Book.GoCab.Model.Driver;
import com.Book.GoCab.Model.Ride;
import com.Book.GoCab.Model.User;
import com.Book.GoCab.Repository.DriverRepository;
import com.Book.GoCab.Repository.RideRepository;
import com.Book.GoCab.Repository.UserRepository;
import com.Book.GoCab.Service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private RideRepository rideRepository;


    @Override
    public Ride bookCab(Long userId, String pickup, String drop) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        List<Driver> availableDrivers = driverRepository.findByAvailableTrue();
        if(availableDrivers.isEmpty()){
            throw  new RuntimeException("No Drivers available Right Now!");
        }

        Driver driver = availableDrivers.get(0);

        int distance = new Random().nextInt(10) + 1;
        double fare = distance * 10;

        Ride ride = new Ride();
        ride.setUser(user);
        ride.setDriver(driver);
        ride.setPickUpLocation(pickup);
        ride.setDropLocation(drop);
        ride.setFare(fare);
        ride.setStatus("Booked");

        Ride savedride = rideRepository.save(ride);

        driver.setAvailable(false);
        driverRepository.save(driver);

        return savedride;
    }

    @Override
    public Ride completeRide(Long rideId) {

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() ->new RuntimeException("Ride Not Found"));

        if("Completed".equalsIgnoreCase(ride.getStatus())){
            throw new RuntimeException("Ride already completed");
        }

        //Set ride as completed
        ride.setStatus("Completed");

        //Set driver available again
        Driver driver = ride.getDriver();
        driver.setAvailable(true);
        driverRepository.save(driver);

        return rideRepository.save(ride);
    }

    @Override
    public List<Ride> getUserRideHistory(Long userId) {
        return rideRepository.findByUserId(userId);
    }

    @Override
    public List<Ride> getDriverRideHistory(Long driverId) {
        return rideRepository.findByDriverId(driverId);
    }

    @Override
    public List<Ride> getRidesByStatus(String status) {
        return rideRepository.findByStatus(status);
    }
}

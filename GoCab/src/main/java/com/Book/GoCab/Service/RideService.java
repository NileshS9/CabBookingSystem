package com.Book.GoCab.Service;

import com.Book.GoCab.Model.Ride;

import java.util.List;

public interface RideService {
    Ride bookCab(Long userId,String pickup,String drop);
    Ride completeRide(Long rideId);
    List<Ride>getUserRideHistory(Long userId);
    List<Ride>getDriverRideHistory(Long driverId);
}

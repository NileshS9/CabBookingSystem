package com.Book.GoCab.Service;

import com.Book.GoCab.Model.Ride;

public interface RideService {
    Ride bookCab(Long userId,String pickup,String drop);
}

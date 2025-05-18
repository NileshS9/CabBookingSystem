package com.Book.GoCab.Controller;

import com.Book.GoCab.Model.Ride;
import com.Book.GoCab.Service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping("/book")
    public Ride bookCab(@RequestParam Long userId,
                        @RequestParam String pickup,
                        @RequestParam String drop){
        return rideService.bookCab(userId,pickup,drop);
    }
}

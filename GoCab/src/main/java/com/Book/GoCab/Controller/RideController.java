package com.Book.GoCab.Controller;

import com.Book.GoCab.Model.Ride;
import com.Book.GoCab.Service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/complete/{rideId}")
    public ResponseEntity<Ride> completeRide(@PathVariable Long rideId){
        Ride completedRide =rideService.completeRide(rideId);
        return ResponseEntity.ok(completedRide);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Ride>> getRidesByStatus(@PathVariable String status){
        List<Ride> rides = rideService.getRidesByStatus(status);
        return ResponseEntity.ok(rides);
   }

   @PutMapping("/{id}/cancel")
   public ResponseEntity<Ride> cancelRide(@PathVariable Long id){
        Ride cancelledRide = rideService.cancelRide(id);
        return ResponseEntity.ok(cancelledRide);
   }

   @GetMapping("/rides")
   public ResponseEntity<List<Ride>> getAllRides(){
        List<Ride> rides =rideService.getAllRides();
        return ResponseEntity.ok(rides);
   }
}

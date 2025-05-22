package com.Book.GoCab.Repository;

import com.Book.GoCab.Model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideRepository extends JpaRepository<Ride,Long> {

    List<Ride>findByUserId(Long userId);
}

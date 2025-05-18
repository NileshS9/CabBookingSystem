package com.Book.GoCab.Repository;

import com.Book.GoCab.Model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride,Long> {
}

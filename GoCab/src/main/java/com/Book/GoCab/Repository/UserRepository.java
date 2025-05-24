package com.Book.GoCab.Repository;

import com.Book.GoCab.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {

    Optional<User> findByPhone(String phone);
}

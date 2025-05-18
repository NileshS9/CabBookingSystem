package com.Book.GoCab.Repository;

import com.Book.GoCab.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
}

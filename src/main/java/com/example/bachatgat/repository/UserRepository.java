package com.example.bachatgat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bachatgat.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}

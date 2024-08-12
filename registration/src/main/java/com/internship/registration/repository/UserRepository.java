package com.internship.registration.repository;

import com.internship.registration.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository <User, Integer> {


   public Optional<User> findByUsername(String username);

    public List<User> findAll();

}
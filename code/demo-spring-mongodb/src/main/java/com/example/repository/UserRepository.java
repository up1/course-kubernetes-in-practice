package com.example.repository;

import com.example.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by achalise on 12/12/16.
 */
public interface UserRepository extends MongoRepository<User, String> {
    public User findByEmail();

}

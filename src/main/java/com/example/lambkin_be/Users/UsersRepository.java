package com.example.lambkin_be.Users;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<UsersEntity , String> {


    Boolean existsByEmail(String email);

    UsersEntity findByEmail(String email);
}

package com.example.lambkin_be.Users.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class UserResponse {
    private String userId;
    private String username;
    private String email;
    private String gender;
    private  String bio;
    private Date dateOfBirth;
    private String token;
}

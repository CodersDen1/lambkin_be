package com.example.lambkin_be.Users.dtos;

import lombok.Data;
import lombok.NonNull;

@Data
public class LoginUserRequest {
    @NonNull private String email;
    @NonNull private String password;

}

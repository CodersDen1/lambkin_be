package com.example.lambkin_be.Users.dtos;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Data
@Setter(AccessLevel.NONE)
public class CreateUserRequest {
     @NonNull private String username;
     @NonNull private String password;
     @NonNull private String email;
     @NonNull private String gender;
     @Nullable private String profileImage;

}

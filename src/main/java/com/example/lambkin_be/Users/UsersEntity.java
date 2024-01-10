package com.example.lambkin_be.Users;

import jakarta.annotation.Nullable;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(onConstructor_ = @PersistenceConstructor)
@Document(collection = "users")
@TypeAlias("UsersEntity")
public class UsersEntity {

    @Id
    private String userId;

    @NonNull
    private String username;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @Nullable
    @DateTimeFormat
    private Date dateOfBirth;

    @NonNull
    private String gender;

    @Nullable
    private String bio;

    @Nullable
    @CreatedDate
    private Date createdAt;

    @Version
    private Long version;
}

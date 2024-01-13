package com.example.lambkin_be.Users;


import com.example.lambkin_be.Security.JWTService;
import com.example.lambkin_be.Users.dtos.CreateUserRequest;
import com.example.lambkin_be.Users.dtos.LoginUserRequest;
import com.example.lambkin_be.Users.dtos.UserResponse;
import com.example.lambkin_be.commons.dtos.ErrorResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UsersController {

     private final UsersService usersService;
     private final ModelMapper modelMapper;
     private final JWTService jwtService;




    public UsersController(UsersService usersService, ModelMapper modelMapper, JWTService jwtService) {
        this.usersService = usersService;
        this.modelMapper = modelMapper;
        this.jwtService = jwtService;
    }


    @PostMapping("")
    ResponseEntity<UserResponse> createNewUser(@RequestBody CreateUserRequest request) throws UsersService.FieldCantBeNullException, UsersService.UserAlreadyExistException , UsersService.InvalidCredentialException {
        var savedUser = usersService.createUser(request);
        var savedUserURI = URI.create("/users/"+savedUser.getUserId());

        var response = modelMapper.map(savedUser, UserResponse.class);

        response.setToken(
                jwtService.createJsonWebToken(savedUser.getUserId())
        );


        return  ResponseEntity.created(savedUserURI).body(response);
    }


    @GetMapping("")
    ResponseEntity<ArrayList<UsersEntity>> getAllUsers(){
        var users= usersService.getAllUser();

        return ResponseEntity.ok((ArrayList<UsersEntity>) users);
    }

    @GetMapping("/{userId}")
    ResponseEntity<UsersEntity> getUserByUserId(@PathVariable("userId") String userId){
          var user = usersService.findUserById(userId);
          return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    ResponseEntity<UserResponse> loginUser(@RequestBody LoginUserRequest req){
        UsersEntity user = usersService.signInUser(req);
        var userResposne = modelMapper.map(user, UserResponse.class);

        userResposne.setToken(jwtService.createJsonWebToken(user.getUserId()));

        return ResponseEntity.ok(userResposne);
    }





    @ExceptionHandler({
            UsersService.UserNotFound.class,
            UsersService.FieldCantBeNullException.class,
            UsersService.UserAlreadyExistException.class,
            UsersService.InvalidCredentialException.class
    })
    ResponseEntity<ErrorResponse> userNotFoundException(Exception e){

        String message;
        HttpStatus status;

        if(e instanceof  UsersService.UserNotFound){
         message = e.getMessage();
         status = HttpStatus.NOT_FOUND;
        } else if (e instanceof  UsersService.UserAlreadyExistException) {
            message="user with that email already exist";
            status = HttpStatus.CONFLICT;
        } else if (e instanceof UsersService.InvalidCredentialException) {
                message=e.getMessage();
                status=HttpStatus.UNAUTHORIZED;
        } else   {
            message="Internal Server Error";
            status = HttpStatus.UNAUTHORIZED;
        }

        ErrorResponse response = ErrorResponse.builder().message(message).build();

        return ResponseEntity.status(status).body(response);
    }

}

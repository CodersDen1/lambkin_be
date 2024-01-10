package com.example.lambkin_be.Users;


import com.example.lambkin_be.Users.dtos.CreateUserRequest;
import com.example.lambkin_be.Users.dtos.LoginUserRequest;
import com.example.lambkin_be.Users.dtos.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsersService {


    private final ModelMapper modelMapper;
    private final UsersRepository usersRepository;

    public UsersService(ModelMapper modelMapper , UsersRepository usersRepository) {
        this.modelMapper = modelMapper;
        this.usersRepository = usersRepository;
    }


    public UsersEntity createUser(CreateUserRequest req) throws FieldCantBeNullException, UserAlreadyExistException {

            UsersEntity newUser = modelMapper.map(req , UsersEntity.class);

             if (usersRepository.existsByEmail(newUser.getEmail())) {
                throw new UserAlreadyExistException();
            }
        return usersRepository.save(newUser);
    }

    public  Iterable<UsersEntity> getAllUser(){
        return  usersRepository.findAll();
    }

    public UsersEntity findUserById(String userId){
        var user = usersRepository.findById(userId).orElseThrow(()-> new UserNotFound(userId));
        return user;
    }

    public UsersEntity signInUser(LoginUserRequest request){
        var userExist = usersRepository.existsByEmail(request.getEmail());
        if(!userExist){
            throw new InvalidCredentialException(request.getEmail());
        }

        return usersRepository.findByEmail(request.getEmail());
    }




    public static class FieldCantBeNullException extends Exception {
        public FieldCantBeNullException(){
            super("One of the required field is empty!");
        }
    }

    public static class UserNotFound extends IllegalArgumentException{
        public UserNotFound(String userId){
            super("user with user id :  "+ userId+" Not found");
        }

    }

    public static  class UserAlreadyExistException extends Exception{
         public  UserAlreadyExistException(){
             super("User with same email already exist");
         }
    }

    public static class InvalidCredentialException extends  IllegalArgumentException{
        public InvalidCredentialException(String email){
            super("user with email does not exist");
        }
    }

}

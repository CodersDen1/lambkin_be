package com.example.lambkin_be.Security;

import com.example.lambkin_be.Users.UsersService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class JWTAuthenticationManager  implements AuthenticationManager {

    private final JWTService jwtService;
    private final  UsersService usersService;

    public JWTAuthenticationManager(JWTService jwtService, UsersService usersService) {
        this.jwtService = jwtService;

        this.usersService = usersService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication instanceof  JWTAuthentication jwtAuthentication){
            var jwt= jwtAuthentication.getCredentials();
            var userId= jwtService.retrieveUserID((String) jwt);

            jwtAuthentication.usersEntity = usersService.findUserById(userId);
            jwtAuthentication.setAuthenticated(true);

            return jwtAuthentication;
        }

        throw new IllegalAccessError("can't authenticate with null jwt authentication");
    }
}

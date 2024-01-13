package com.example.lambkin_be.Security;

import com.example.lambkin_be.Users.UsersEntity;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.security.auth.Subject;
import java.util.Collection;

public class JWTAuthentication implements Authentication {

    String jwt;
    UsersEntity usersEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return jwt;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public UsersEntity getPrincipal() {
        return usersEntity;
    }

    @Override
    public boolean isAuthenticated() {
        return (usersEntity!=null);
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public boolean equals(Object another) {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean implies(Subject subject){
        return  Authentication.super.implies(subject);
    }
}

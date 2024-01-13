package com.example.lambkin_be.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {

    private static final String JWT_KEY = "asdangkavhnasaasdsaqvdsvfgmtukrthgdscsafcmasasdadjnsasasdcsdfcfa65655655";

    private Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);

    public String createJsonWebToken(String userID){
        return JWT.create()
                .withSubject(userID)
                .withIssuedAt(new Date())
                .sign(algorithm);
    }

    public String retrieveUserID(String jwtString){
        var decodedJsonWebToken = JWT.decode(jwtString);
        //userID = decodedJsonWebToken.getSubject();
        return decodedJsonWebToken.getSubject();
    }
}

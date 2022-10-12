package com.moon.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Calendar;
import java.util.Date;

public class JwtUtils {
    //签名
    private static final String sign = "abc";

    //生成token
    public static <T> String getToken(T user, int exp) {
        try {
            //payload
            ObjectMapper mapper = new ObjectMapper();
            String payload = mapper.writeValueAsString(user);
            //sign
            Algorithm algorithm = Algorithm.HMAC256(sign);
            Calendar calendar = Calendar.getInstance();
            //exp
            calendar.add(Calendar.MILLISECOND, exp);
            //make token
            return JWT.create().withClaim("payload", payload)
                    .withExpiresAt(calendar.getTime())
                    .withIssuedAt(new Date())
                    .sign(algorithm);
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    //验证token
    public static boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(sign);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            jwtVerifier.verify(token);
            return true;
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    //获取用户对象
    public static <T> T getUser(String token, Class<T> clazz) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(sign);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            String payload = decodedJWT.getClaim("payload").asString();
            ObjectMapper mapper = new ObjectMapper();
            return (T) mapper.readValue(payload, clazz);
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    //
}

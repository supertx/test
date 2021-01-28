package com.qinli;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;

/**
 * @author supermantx
 * @time 2021/1/28 15:18
 * 测试生成jwt
 */
public class JwtTest {

    @Test
    public void contextLoads(){
        HashMap<String, Object> map = new HashMap<>();

        Calendar date = Calendar.getInstance();
        date.add(Calendar.SECOND, 200);
        String token = JWT.create()
                .withHeader(map) // Header
                .withClaim("userId", 21)
                .withClaim("username", "xiaochen")
                .withExpiresAt(date.getTime()) // 过期时间
                .sign(Algorithm.HMAC256("!@#!@da21")); // 令牌密钥

        System.out.println(token);
    }

    @Test
    public void test(){
       // 验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!@#!@da21")).build();
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTE4MTkyMzUsInVzZXJJZCI6MjEsInVzZXJuYW1lIjoieGlhb2NoZW4ifQ.bcKRhiBT1gJ50ACVmCvrVjIUM_JAzVUHXEWO_a4qNrQ");
        System.out.println(verify);
        System.out.println(verify.getClaim("userId").asString());
        System.out.println(verify.getClaim("username").asString()  );
    }
}

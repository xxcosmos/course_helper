package me.xiaoyuu.course_helper.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import me.xiaoyuu.course_helper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class JwtConfig {
    private static final String SECRET_KEY = "5371f568a45e5ab1f442c38e0932aef24447139b";
    private static long expire_time = 3600;
    @Autowired
    private StringRedisTemplate redisTemplate;

    public String getToken(User user) {
        String jwtId = UUID.randomUUID().toString();
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        String token = JWT.create().withClaim("openid", user.getOpenid())
                .withClaim("sessionKey", user.getSessionKey())
                .withClaim("jwtId", jwtId)
                .withExpiresAt(new Date(System.currentTimeMillis() + expire_time * 1000))
                .sign(algorithm);
        redisTemplate.opsForValue().set("JWT-SESSION-" + jwtId, token, expire_time, TimeUnit.SECONDS);
        return token;
    }

    public boolean verifyToken(String token) {
        try {
            String redisToken = redisTemplate.opsForValue().get("JWT-SESSION-" + getJwtIdByToken(token));
            if (redisToken == null || !redisToken.equals(token)) return false;

            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("openid", getOpenIdByToken(redisToken))
                    .withClaim("sessionKey", getSessionKeyByToken(redisToken))
                    .withClaim("jwtId", getJwtIdByToken(redisToken))
                    .acceptExpiresAt(System.currentTimeMillis() + expire_time * 1000)
                    .build();
            verifier.verify(redisToken);
            redisTemplate.opsForValue().set("JWT-SESSION-" + getJwtIdByToken(token), redisToken, expire_time, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 根据Token获取wxOpenId(注意坑点 : 就算token不正确，也有可能解密出wxOpenId,同下)
     */
    public String getOpenIdByToken(String token) throws JWTDecodeException {
        return JWT.decode(token).getClaim("openid").asString();
    }

    /**
     * 根据Token获取sessionKey
     */
    public String getSessionKeyByToken(String token) throws JWTDecodeException {
        return JWT.decode(token).getClaim("sessionKey").asString();
    }

    /**
     * 根据Token 获取jwt-id
     */
    private String getJwtIdByToken(String token) throws JWTDecodeException {
        return JWT.decode(token).getClaim("jwtId").asString();
    }

}

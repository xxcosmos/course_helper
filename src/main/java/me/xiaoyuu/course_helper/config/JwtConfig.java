package me.xiaoyuu.course_helper.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import me.xiaoyuu.course_helper.constant.Constant;
import me.xiaoyuu.course_helper.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static me.xiaoyuu.course_helper.constant.Constant.JWT.EXPIRE_TIME;
import static me.xiaoyuu.course_helper.constant.Constant.JWT.SECRET_KEY;

@Configuration
public class JwtConfig {

    private final StringRedisTemplate stringRedisTemplate;

    public JwtConfig(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }


    public String generateToken(User user) {
        String jwtId = UUID.randomUUID().toString();
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        String token = JWT.create().withClaim("openid", user.getOpenid())
                .withClaim("jwtId", jwtId)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME * 1000))
                .sign(algorithm);
        stringRedisTemplate.opsForValue().set("JWT-SESSION-" + jwtId, token, EXPIRE_TIME, TimeUnit.SECONDS);
        return token;
    }

    boolean verifyToken(String token) {
        try {
            String redisToken = stringRedisTemplate.opsForValue().get("JWT-SESSION-" + getJwtIdByToken(token));
            if (redisToken == null || !redisToken.equals(token)) return false;

            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("openid", getOpenIdByToken(redisToken))
                    .withClaim("jwtId", getJwtIdByToken(redisToken))
                    .acceptExpiresAt(System.currentTimeMillis() + EXPIRE_TIME * 1000)
                    .build();
            verifier.verify(redisToken);
            stringRedisTemplate.opsForValue().set("JWT-SESSION-" + getJwtIdByToken(token), redisToken, EXPIRE_TIME, TimeUnit.SECONDS);
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
     * 根据Token 获取jwt-id
     */
    private String getJwtIdByToken(String token) throws JWTDecodeException {
        return JWT.decode(token).getClaim("jwtId").asString();
    }

}

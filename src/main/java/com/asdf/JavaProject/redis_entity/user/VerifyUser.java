package com.asdf.JavaProject.redis_entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@AllArgsConstructor
@RedisHash(value = "verify_user", timeToLive = 60 * 3)
public class VerifyUser {

    @Id
    private String email;
}

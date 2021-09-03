package com.asdf.JavaProject.redis_entity.email;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VerifyCodeRedisRepository extends CrudRepository<VerifyCode, String> {
    Optional<VerifyCode> findByCode(String code);
}

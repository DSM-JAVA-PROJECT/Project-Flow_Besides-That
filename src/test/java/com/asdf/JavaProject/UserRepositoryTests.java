package com.asdf.JavaProject;

import static org.assertj.core.api.Assertions.assertThat;

import com.asdf.JavaProject.entity.user.User;
import com.asdf.JavaProject.entity.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = User.builder()
                .email("test@test.com")
                .name("wrea")
                .password("adsf")
                .phoneNumber("010-1234-1234")
                .build();

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindUserByEmail(){
        String email = "test@test.com";

        User user = repo.findByEmail(email).orElseThrow();

        assertThat(user).isNotNull();
    }
}

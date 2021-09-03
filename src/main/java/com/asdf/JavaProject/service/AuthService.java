package com.asdf.JavaProject.service;

import com.asdf.JavaProject.config.JwtToken;
import com.asdf.JavaProject.dto.ReturnToken;
import com.asdf.JavaProject.dto.TokenContent;
import com.asdf.JavaProject.dto.user.*;
import com.asdf.JavaProject.entity.user.User;
import com.asdf.JavaProject.entity.user.UserRepository;
import com.asdf.JavaProject.redis_entity.user.VerifyUserRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    private final VerifyUserRedisRepository verifyUserRedisRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtToken jwtToken;

    public String signUp(SignUpUser s_user) throws Exception {

        if (verifyUserRedisRepository.findById(s_user.getEmail()).isEmpty()) {
            throw new Exception("인증되지 않은 이메일 입니다.");
        }

        User user = User.builder()
                .name(s_user.getName())
                .email(s_user.getEmail())
                .password(passwordEncoder.encode(s_user.getPassword()))
                .phoneNumber(s_user.getPhone_number())
                .build();

        userRepository.save(user);

        return "success";
    }

    public ReturnToken signIn(SignInUser s_user) throws Exception {
        User user = userRepository.findByEmail(s_user.getEmail()).orElseThrow();
        if (user == null) {
            new Exception("이메일이 잘못되었습니다.");
        }
        if (passwordEncoder.matches(s_user.getPassword(), user.getPassword())) {
            new Exception("비밀번호가 잘못되었습니다.");
        }
        return ReturnToken.builder()
                .accessToken(jwtToken.createToken(user))
                .refreshToken(jwtToken.createRefreshToken(user))
                .build();
    }

    public MyPageUser myPage(String token) throws Exception{
        TokenContent tokenContext = jwtToken.decodeToken(token);

        User user = userRepository.findByEmail(tokenContext.getEmail()).orElseThrow();

        MyPageUser myPageUser = MyPageUser.builder()
                .name(user.getName())
                .phone_number(user.getPhoneNumber())
                .projects(user.getProjects())
                .build();

        System.out.println(user);

        return myPageUser;
    }

    public void modifyUser(String token, ModifyUser modifyUser) throws Exception{
        TokenContent tokenContext = jwtToken.decodeToken(token);

        User user = userRepository.findByEmail(tokenContext.getEmail()).orElseThrow();

        User updateUser = User.builder()
                .id(user.getId())
                .name(modifyUser.getName())
                .email(user.getEmail())
                .password(passwordEncoder.encode(modifyUser.getPassword()))
                .phoneNumber(modifyUser.getPhone_number())
                .profileImage(modifyUser.getProfile_image())
                .projects(user.getProjects())
                .plans(user.getPlans())
                .build();

        userRepository.save(updateUser);
    }

    public FindByToken findByToken(String token) throws Exception{
        TokenContent tokenContext = jwtToken.decodeToken(token);

        User user = userRepository.findByEmail(tokenContext.getEmail()).orElseThrow();

        return FindByToken.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .phone_number(user.getPhoneNumber())
                .profile_image(user.getProfileImage())
                .build();
    }
}

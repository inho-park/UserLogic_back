package com.example.csrex.user.service;

import com.example.csrex.user.domain.User;
import com.example.csrex.user.domain.UserRepository;
import com.example.csrex.user.dto.request.SignUpRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {

    final private UserRepository userRepository;

    public String register(SignUpRequestDTO dto) {
        User user = User.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .password(dto.getPassword())
                .age(dto.getAge())
                .build();

        userRepository.save(user);

        return user.getName();
    }


}

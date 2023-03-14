package com.example.csrex.user.service;

import com.example.csrex.user.domain.Member;
import com.example.csrex.user.domain.MemberRepository;
import com.example.csrex.user.dto.request.SignInRequestDTO;
import com.example.csrex.user.dto.request.SignUpRequestDTO;
import com.example.csrex.user.dto.response.NameResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {

    final private MemberRepository userRepository;

    public NameResponseDTO signUp(SignUpRequestDTO dto) {
        if(!userRepository.existsById(dto.getEmail())){
            Member user = Member.builder()
                    .email(dto.getEmail())
                    .name(dto.getName())
                    .password(dto.getPassword())
                    .age(dto.getAge())
                    .build();
            userRepository.save(user);
            return new NameResponseDTO(user.getName());
        } else
            throw new RuntimeException();

    }

    public NameResponseDTO signIn(SignInRequestDTO dto) {

        Member entity = userRepository.getReferenceById(dto.getEmail());


        if (entity.getPassword().equals(dto.getPassword())) 
            return new NameResponseDTO(entity.getName());
        else throw new RuntimeException();
    }


}

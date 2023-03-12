package com.example.csrex.user.controller;

import com.example.csrex.user.dto.request.SignUpRequestDTO;
import com.example.csrex.user.dto.response.ResponseDTO;
import com.example.csrex.user.dto.response.ResponseErrorDTO;
import com.example.csrex.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

    final private UserService userService;

    @GetMapping
    public String signIn(@RequestBody SignUpRequestDTO dto) {
        log.info("api get.....................................");
        return dto.getName();
    }

    @PostMapping
    public ResponseEntity signUp(@RequestBody SignUpRequestDTO dto) {
        try {
            ResponseDTO response = ResponseDTO.builder().name(userService.register(dto)).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(Exception e) {
            ResponseErrorDTO error = ResponseErrorDTO.builder().msg(e.getMessage()).build();
            return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY);
        }
    }
}

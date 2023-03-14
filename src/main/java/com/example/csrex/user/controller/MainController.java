package com.example.csrex.user.controller;

import com.example.csrex.user.dto.request.SignInRequestDTO;
import com.example.csrex.user.dto.request.SignUpRequestDTO;
import com.example.csrex.user.dto.response.NameResponseDTO;
import com.example.csrex.user.dto.response.SingleResult;
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
    public ResponseEntity login(@RequestBody SignInRequestDTO dto) {
        try {
            NameResponseDTO response = userService.signIn(dto);
            return new ResponseEntity<>(response, HttpStatus.OK) ;
        } catch (Exception e) {
            SingleResult<String> error = new SingleResult<>(e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity join(@RequestBody SignUpRequestDTO dto) {
        try {
            NameResponseDTO response = userService.signUp(dto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(Exception e) {
            SingleResult<String> error = new SingleResult<>(e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}

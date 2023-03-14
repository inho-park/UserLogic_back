package com.example.csrex.user.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInRequestDTO {
    private String email;
    private String password;
}

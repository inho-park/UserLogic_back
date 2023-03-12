package com.example.csrex.user.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpRequestDTO {
    private String email;
    private String name;
    private String password;
    private Long age;
}

package com.example.csrex.user.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseErrorDTO {
    private String msg;
}

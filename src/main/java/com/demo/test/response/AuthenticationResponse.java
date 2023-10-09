package com.demo.test.response;

import lombok.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationResponse {

    private String token;

    public void setToken(String token) {
        this.token = token;
    }
}

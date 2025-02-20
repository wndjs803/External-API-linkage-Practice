package com.example.webdesignpractice.user.dto.request;

public record CreateUserRequest(
        String name,
        String email,
        String password
) {
}

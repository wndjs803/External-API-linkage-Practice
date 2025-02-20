package com.example.webdesignpractice.user.dto;

public record UserDto(
        Long id,
        String name,
        String email
) {
    public static UserDto of(Long id, String name, String email) {
        return new UserDto(id, name, email);
    }
}

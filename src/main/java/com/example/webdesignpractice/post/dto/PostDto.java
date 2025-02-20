package com.example.webdesignpractice.post.dto;

import com.example.webdesignpractice.user.dto.UserDto;

public record PostDto(
        Long id,
        String title,
        String content
) {
    public static PostDto of(Long id, String title, String content) {
        return new PostDto(id, title, content);
    }
}

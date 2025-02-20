package com.example.webdesignpractice.post.dto.request;

public record CreatePostRequest(
        Long userId,
        String title,
        String content
) {
}

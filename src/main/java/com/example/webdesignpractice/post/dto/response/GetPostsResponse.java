package com.example.webdesignpractice.post.dto.response;

import com.example.webdesignpractice.post.dto.PostDto;

import java.util.List;

public record GetPostsResponse(
        List<PostDto> postDtos,
        int page,
        int size,
        int totalPage
) {
    public static GetPostsResponse of(List<PostDto> postDtos, int page, int size, int totalPage) {
        return new GetPostsResponse(postDtos, page, size, totalPage);
    }
}

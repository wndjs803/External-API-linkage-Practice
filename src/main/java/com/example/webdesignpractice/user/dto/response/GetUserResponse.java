package com.example.webdesignpractice.user.dto.response;

import com.example.webdesignpractice.post.dto.PostDto;
import com.example.webdesignpractice.user.dto.UserDto;

import java.util.List;

public record GetUserResponse(
        UserDto userDto,
        List<PostDto> postDtos
) {
    public static GetUserResponse of(UserDto userDto, List<PostDto> postDtos) {
        return new GetUserResponse(userDto, postDtos);
    }
}

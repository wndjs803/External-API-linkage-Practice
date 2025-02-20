package com.example.webdesignpractice.user.service;

import com.example.webdesignpractice.post.dto.PostDto;
import com.example.webdesignpractice.post.entity.Post;
import com.example.webdesignpractice.post.repository.PostRepository;
import com.example.webdesignpractice.user.dto.request.CreateUserRequest;
import com.example.webdesignpractice.user.dto.UserDto;
import com.example.webdesignpractice.user.dto.response.GetUserResponse;
import com.example.webdesignpractice.user.entity.User;
import com.example.webdesignpractice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserDto createUser(CreateUserRequest request) {
        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();

        User createdUser = userRepository.save(user);
        return UserDto.of(createdUser.getId(), createdUser.getName(), createdUser.getName());
    }

    public GetUserResponse findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        List<Post> posts = postRepository.findAll();

        UserDto userDto = UserDto.of(id, user.getName(), user.getEmail());
        List<PostDto> postDtos = posts.stream()
                .map(post -> PostDto.of(post.getId(), post.getTitle(), post.getContent()))
                .toList();

        return GetUserResponse.of(userDto, postDtos);
    }

    @Transactional
    public UserDto updateUser(Long id, CreateUserRequest request) {
        User user = userRepository.findById(id)
                        .orElseThrow(IllegalArgumentException::new);
        user.updateUser(request.name(), request.email(), request.password());

        return UserDto.of(id, user.getName(), user.getEmail());
    }
}

package com.example.webdesignpractice.post.service;

import com.example.webdesignpractice.post.dto.request.CreatePostRequest;
import com.example.webdesignpractice.post.dto.PostDto;
import com.example.webdesignpractice.post.dto.response.GetPostsResponse;
import com.example.webdesignpractice.post.entity.Post;
import com.example.webdesignpractice.post.repository.PostRepository;
import com.example.webdesignpractice.user.entity.User;
import com.example.webdesignpractice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final int PAGE_SIZE = 5;

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostDto createPost(CreatePostRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(IllegalArgumentException::new);

        Post post = Post.builder()
                .title(request.title())
                .content(request.content())
                .user(user)
                .build();

        Post createdPost = postRepository.save(post);

        return PostDto.of(createdPost.getId(), createdPost.getTitle(), createdPost.getContent());
    }

    public PostDto findPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        return PostDto.of(post.getId(), post.getTitle(), post.getContent());
    }

    public GetPostsResponse findAllPosts(Pageable pageable) {
        Page<Post> posts = postRepository.findAll(pageable);
        List<PostDto> postDtos = posts.stream()
                .map(post -> PostDto.of(post.getId(), post.getTitle(), post.getContent()))
                .toList();

        return GetPostsResponse.of(postDtos, pageable.getPageNumber(), posts.getSize(), posts.getTotalPages());
    }

    @Transactional
    public PostDto updatePost(Long id, CreatePostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        if (!post.isOwner(request.userId())) {
            throw new RuntimeException();
        }

        post.updatePost(request.title(), request.content());

        return PostDto.of(post.getId(), post.getTitle(), post.getContent());
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}

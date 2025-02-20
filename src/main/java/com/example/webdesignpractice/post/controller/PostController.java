package com.example.webdesignpractice.post.controller;

import com.example.webdesignpractice.post.dto.request.CreatePostRequest;
import com.example.webdesignpractice.post.dto.PostDto;
import com.example.webdesignpractice.post.dto.response.GetPostsResponse;
import com.example.webdesignpractice.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
//    - `POST /api/posts`: 게시글 생성 (userId 참조)
//- `GET /api/posts/{id}`, `GET /api/posts` (페이징)
//            - `PUT /api/posts/{id}`, `DELETE /api/posts/{id}`

    @PostMapping("")
    public ResponseEntity<PostDto> createPost(@RequestBody CreatePostRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(postService.createPost(request));
    }

    @GetMapping("{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findPostById(id));
    }

    @GetMapping("")
    public ResponseEntity<GetPostsResponse> getPosts(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(postService.findAllPosts(pageable));
    }

    @PutMapping("{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long id, @RequestBody CreatePostRequest request) {
        return ResponseEntity.ok(postService.updatePost(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok("success");
    }
}

package com.example.webdesignpractice.post.repository;

import com.example.webdesignpractice.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAll(Pageable pageable);
}

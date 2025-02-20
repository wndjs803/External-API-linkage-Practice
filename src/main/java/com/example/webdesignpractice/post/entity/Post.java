package com.example.webdesignpractice.post.entity;

import com.example.webdesignpractice.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public void updatePost(String title, String content) {
        this.updateTitle(title);
        this.updateContent(content);
    }

    private void updateTitle(String title) {
        this.title = title;
    }

    private void updateContent(String content) {
        this.content = content;
    }

    public boolean isOwner(Long id) {
        return this.user.getId().equals(id);
    }
}

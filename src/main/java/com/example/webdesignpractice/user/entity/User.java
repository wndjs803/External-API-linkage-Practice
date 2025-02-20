package com.example.webdesignpractice.user.entity;

import com.example.webdesignpractice.post.entity.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    public void updateUser(String name, String email, String password) {
        this.updateName(name);
        this.updateEmail(email);
        this.updatePassword(password);
    }
    private void updateName(String name) {
        this.name = name;
    }

    private void updateEmail(String email) {
        this.email = email;
    }

    private void updatePassword(String password) {
        this.password = password;
    }


}

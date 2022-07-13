package com.example.graphqlsample.model;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = LAZY, optional = false)
    private Post post;

    public Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }

    public void commentOnPost(Post post) {
        this.post = post;
    }

    public void updateContent(String content) {
        this.content = content;
    }

}

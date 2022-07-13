package com.example.graphqlsample.dto;

import com.example.graphqlsample.model.Post;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreatePostRequest {

    private final String title;

    private final String content;

    public Post toEntity() {
        return new Post(title, content);
    }

}

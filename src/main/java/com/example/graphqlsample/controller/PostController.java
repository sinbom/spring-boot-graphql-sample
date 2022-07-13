package com.example.graphqlsample.controller;

import com.example.graphqlsample.dto.CreatePostRequest;
import com.example.graphqlsample.dto.PostDto;
import com.example.graphqlsample.model.Post;
import com.example.graphqlsample.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @QueryMapping
    public PostDto getPost(@Argument Long id) {
        Post post = postService.getPost(id);

        return post == null ? null : new PostDto(post);
    }

    @MutationMapping
    public PostDto createPost(@Argument CreatePostRequest request) {
        Post post = postService.createPost(request);

        return new PostDto(post);
    }

}

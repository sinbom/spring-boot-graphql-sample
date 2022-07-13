package com.example.graphqlsample.service;

import com.example.graphqlsample.dto.CreatePostRequest;
import com.example.graphqlsample.model.Post;
import com.example.graphqlsample.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post getPost(Long id) {
        return postRepository
            .findById(id)
            .orElse(null);
    }

    public Post createPost(CreatePostRequest request) {
        return postRepository.save(request.toEntity());
    }

}

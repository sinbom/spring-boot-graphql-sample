package com.example.graphqlsample.service;

import com.example.graphqlsample.dto.CreateCommentRequest;
import com.example.graphqlsample.model.Comment;
import com.example.graphqlsample.model.Post;
import com.example.graphqlsample.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final PostService postService;

    public Comment getComment(Long id) {
        return commentRepository
            .findById(id)
            .orElse(null);
    }

    public Comment createPost(CreateCommentRequest request) {
        Post post = postService.getPost(request.getPostId());
        Comment comment = new Comment(request.getContent(), post);

        commentRepository.save(comment);

        return comment;
    }

}

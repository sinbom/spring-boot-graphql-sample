package com.example.graphqlsample.controller;

import com.example.graphqlsample.dto.CommentDto;
import com.example.graphqlsample.dto.CreateCommentRequest;
import com.example.graphqlsample.model.Comment;
import com.example.graphqlsample.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @QueryMapping
    public CommentDto getComment(@Argument Long id) {
        Comment comment = commentService.getComment(id);

        return comment == null ? null : new CommentDto(comment);
    }

    @MutationMapping
    public CommentDto createComment(@Argument CreateCommentRequest request) {
        Comment comment = commentService.createPost(request);

        return new CommentDto(comment);
    }

}

package com.example.graphqlsample.dto;

import com.example.graphqlsample.model.Comment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentDto {

    private final Long id;

    private final String content;

    public CommentDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
    }

}

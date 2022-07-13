package com.example.graphqlsample.dto;

import static java.util.stream.Collectors.toList;

import com.example.graphqlsample.model.Post;
import java.util.List;
import lombok.Getter;

@Getter
public class PostDto {

    private final Long id;

    private final String title;

    private final String content;

    private final List<CommentDto> comments;

    public PostDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.comments = post
            .getComments()
            .stream()
            .map(CommentDto::new)
            .collect(toList());
    }

}

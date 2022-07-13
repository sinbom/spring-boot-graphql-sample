package com.example.graphqlsample.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateCommentRequest {

    private final String content;

    private final Long postId;

}

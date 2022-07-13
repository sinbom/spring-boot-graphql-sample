package com.example.graphqlsample;

import com.example.graphqlsample.model.Comment;
import com.example.graphqlsample.model.Post;
import com.example.graphqlsample.repository.CommentRepository;
import com.example.graphqlsample.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationInitializer implements ApplicationRunner {

    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Post post = new Post("title 1", "content 1");
        Post post2 = new Post("title 2", "content 2");
        Post post3 = new Post("title 3", "content 3");

        Comment comment = new Comment("content 1-1", post);
        Comment comment2 = new Comment("content 1-2", post);
        Comment comment3 = new Comment("content 1-3", post);
        Comment comment4 = new Comment("content 2-1", post2);
        Comment comment5 = new Comment("content 2-2", post2);
        Comment comment6 = new Comment("content 2-3", post2);
        Comment comment7 = new Comment("content 3-1", post3);
        Comment comment8 = new Comment("content 3-2", post3);
        Comment comment9 = new Comment("content 3-3", post3);

        post.addComment(comment);
        post.addComment(comment2);
        post.addComment(comment3);
        post2.addComment(comment4);
        post2.addComment(comment5);
        post2.addComment(comment6);
        post3.addComment(comment7);
        post3.addComment(comment8);
        post3.addComment(comment9);

        postRepository.save(post);
        postRepository.save(post2);
        postRepository.save(post3);

        commentRepository.save(comment);
        commentRepository.save(comment2);
        commentRepository.save(comment3);
        commentRepository.save(comment4);
        commentRepository.save(comment5);
        commentRepository.save(comment6);
        commentRepository.save(comment7);
        commentRepository.save(comment8);
        commentRepository.save(comment9);
    }

}

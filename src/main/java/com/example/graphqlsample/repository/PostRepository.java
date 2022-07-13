package com.example.graphqlsample.repository;

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.FETCH;

import com.example.graphqlsample.model.Post;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Transactional(readOnly = true)
    @EntityGraph(type = FETCH, attributePaths = "comments")
    Optional<Post> findById(Long id);

}

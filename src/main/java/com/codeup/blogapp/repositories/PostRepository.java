package com.codeup.blogapp.repositories;



import com.codeup.blogapp.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByTitle(String title);

    Post findByBody(String body);



}

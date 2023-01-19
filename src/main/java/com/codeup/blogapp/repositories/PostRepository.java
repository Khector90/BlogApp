package com.codeup.blogapp.repositories;



import com.codeup.blogapp.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByTitle(String title);

    Post findByBody(String body);

    // The following method is equivalent to the built in `getById` method, there's no need to create this example
//    @Query("from Ad a where a.id like ?1")
//    Ad getAdById(long id);

    // The following method shows you how to use named parameters in a HQL custom query:
//    @Query("from Ad a where a.title like %:term%")
//    List<Ad> searchByTitleLike(@Param("term") String term);

}

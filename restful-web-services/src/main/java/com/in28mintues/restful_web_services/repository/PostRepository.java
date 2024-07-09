package com.in28mintues.restful_web_services.repository;

import com.in28mintues.restful_web_services.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}

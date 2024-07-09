package com.in28mintues.restful_web_services.repository;

import com.in28mintues.restful_web_services.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}

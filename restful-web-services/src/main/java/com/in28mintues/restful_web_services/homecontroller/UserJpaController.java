package com.in28mintues.restful_web_services.homecontroller;

import com.in28mintues.restful_web_services.exception.UserNotFoundException;
import com.in28mintues.restful_web_services.repository.PostRepository;
import com.in28mintues.restful_web_services.repository.UserRepository;
import com.in28mintues.restful_web_services.user.Post;
import com.in28mintues.restful_web_services.user.User;
import com.in28mintues.restful_web_services.user.UserDapService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
public class UserJpaController {

    @Autowired
    UserDapService userDapService;

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @GetMapping("/jpa/allusers")
    public List<User> allUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/userses/{id}")
    public EntityModel<Optional<User>> findById(@PathVariable Long id)  {
        Optional<User> findOne = userRepository.findById(id);
        if(findOne.isEmpty())
            throw new UserNotFoundException("id{}:",id);
        EntityModel<Optional<User>> entityModel=EntityModel.of(findOne);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).allUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable Long id)  {

        userDapService.deleteById(id);
    }
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retriveUserAllUsers(@PathVariable Long id)  {

        Optional<User> findOne = userRepository.findById(id);
        if(findOne.isEmpty())
            throw new UserNotFoundException("id{}:",id);
        return findOne.get().getPost();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> saveAllUsers(@PathVariable Long id, @RequestBody @Valid Post post)  {

        Optional<User> findOne = userRepository.findById(id);
        if(findOne.isEmpty())
            throw new UserNotFoundException("id{}:",id);
        post.setUser(findOne.get());
        Post savedPost =postRepository.save(post);
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequestUri().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();

    }


    @PostMapping("/jpa/saveusers")
    public ResponseEntity<User> saveUsers(@RequestBody @Valid User user){
        User savedUser=userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}

package com.in28mintues.restful_web_services.homecontroller;

import com.in28mintues.restful_web_services.exception.UserNotFoundException;
import com.in28mintues.restful_web_services.user.User;
import com.in28mintues.restful_web_services.user.UserDapService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDapService userDapService;

    @GetMapping("/allusers")
    public List<User> allUsers(){
        return userDapService.AllUsers();
    }
    @GetMapping("/user/{id}")
    public EntityModel<User> findById(@PathVariable Long id)  {
        User findOne = userDapService.findById(id);
        if(findOne!=null)
            throw new UserNotFoundException("id{}:",id);
        EntityModel<User> entityModel=EntityModel.of(findOne);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).allUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id)  {
        userDapService.deleteById(id);
    }
    @PostMapping("/saveusers")
    public ResponseEntity<User> saveUsers(@RequestBody @Valid User user){
        User savedUser=userDapService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}

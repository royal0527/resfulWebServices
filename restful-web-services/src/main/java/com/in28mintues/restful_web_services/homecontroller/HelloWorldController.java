package com.in28mintues.restful_web_services.homecontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/helloworld")
    public String helloworld(){
        return "helloworld";

    }

    @GetMapping("/helloworldbean")
    public HelloWorldBean helloworldBean(){
        return new HelloWorldBean("helloworld");

    }

    @GetMapping("/helloworldpathvariable/{name}")
    public HelloWorldBean helloworldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s",name));

    }
}

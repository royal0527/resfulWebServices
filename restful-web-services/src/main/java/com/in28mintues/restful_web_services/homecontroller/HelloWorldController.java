package com.in28mintues.restful_web_services.homecontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController

public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource){
        this.messageSource=messageSource;
    }

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

    @GetMapping("/hello-world-internationalized")
    public String helloworldinternationalized(){
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"default Message",locale);
        //return "hello-world-internationalized";
    }
}

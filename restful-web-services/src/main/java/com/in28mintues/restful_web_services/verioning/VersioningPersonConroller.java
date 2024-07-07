package com.in28mintues.restful_web_services.verioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonConroller {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionPerson(){
        return new PersonV1("bob charlie ");

    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionPerson(){
        return new PersonV2(new Name("Bob","Charli"));
    }

}

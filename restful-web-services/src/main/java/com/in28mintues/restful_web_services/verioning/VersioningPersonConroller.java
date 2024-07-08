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

    @GetMapping(path = "/person",params = "version=1")
    public PersonV1 getFirstVersionPersoRequestParamn(){
        return new PersonV1("bob charlie ");

    }

    @GetMapping(path = "/person/header",headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionHeader(){
        return new PersonV1("bob charlie ");

    }
    @GetMapping (path = "/person/accept", produces = "application/vnd.company.app-v1+json")
            public PersonV1 getFirstVersion() {
            return new PersonV1("Bob Charlie");
            }

}

package com.in28mintues.restful_web_services.homecontroller;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class HelloWorldBean {

    private String message;
    public HelloWorldBean(String message) {
        this.message=message;
    }
}

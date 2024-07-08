package com.in28mintues.restful_web_services.filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("SomeBeanFilter")
//jsonIgnore property @class level
//@JsonIgnoreProperties({"field1","field2"})
public class SomeBean {

    private String field1;
    //jsonignore properties @field level
    //@JsonIgnore
    private String field2;
    private String field3;
}

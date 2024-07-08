package com.in28mintues.restful_web_services.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    @Size(min = 2)
    @JsonProperty("User Name")
    private String name;
    @Past
    @JsonProperty("DOB")
    private LocalDate dateOfBirth;

}

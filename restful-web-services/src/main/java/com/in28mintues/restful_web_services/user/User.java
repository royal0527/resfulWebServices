package com.in28mintues.restful_web_services.user;

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
    private String name;
    @Past
    private LocalDate dateOfBirth;

}

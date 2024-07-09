package com.in28mintues.restful_web_services.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2)
   // @JsonProperty("User Name")
    private String name;
    @Past
   // @JsonProperty("DOB")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> post;

}

package com.in28mintues.restful_web_services.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private LocalDate timeStamp;
    private String message;
    private String details;

}

package com.example.book_my_show.DTOs;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//This is just an object that will be used to take request from postman
//It will contain the parameter that we want to send from postman
//Id is not here because we don't want to send it from Postman
public class UserEntryDto {
    private String name ;
    private String email ;
    private int age ;
    private int mobNo ;
    private String address ;
}

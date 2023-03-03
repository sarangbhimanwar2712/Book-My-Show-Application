package com.example.book_my_show.Controllers;

import com.example.book_my_show.EntryDTOs.UserEntryDto;
import com.example.book_my_show.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService ;

    @PostMapping("/add")
    public ResponseEntity<String> createUser(@RequestBody() UserEntryDto userEntryDto){

        try{
            String s = userService.createUser(userEntryDto);
            return  new ResponseEntity<>(s, HttpStatus.CREATED) ;
        }catch (Exception e){
            String result = "User could not be added" ;
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST) ;
        }
    }
}

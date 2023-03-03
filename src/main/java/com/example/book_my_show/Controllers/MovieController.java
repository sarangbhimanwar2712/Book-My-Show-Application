package com.example.book_my_show.Controllers;

import com.example.book_my_show.EntryDTOs.MovieEntryDto;
import com.example.book_my_show.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService ;

    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDto movieEntryDto) throws Exception {

        try{
            String s = movieService.addMovie(movieEntryDto);
            return new ResponseEntity<>(s,HttpStatus.CREATED) ;
        }catch (Exception e){
            String response = e.toString() ;//"Movie not added" ;
            return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST) ;
        }
    }


}

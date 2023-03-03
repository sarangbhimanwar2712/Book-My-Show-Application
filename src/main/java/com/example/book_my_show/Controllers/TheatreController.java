package com.example.book_my_show.Controllers;

import com.example.book_my_show.EntryDTOs.TheatreEntryDto;
import com.example.book_my_show.Models.Theatre;
import com.example.book_my_show.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService ;

    @PostMapping("/add_theatre")
    public ResponseEntity<String> addTheatre (@RequestBody TheatreEntryDto theatreEntryDto) throws Exception {
        try{
            String s = theatreService.addTheatre(theatreEntryDto);
            return new ResponseEntity<>(s, HttpStatus.CREATED) ;
        }catch (Exception e){
            String response = "Theatre could not be added" ;
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST) ;
        }
    }

    @GetMapping("/get_All_Theatre")
    public List<Theatre> getALlTheatre(){
        return theatreService.getAllTheatre() ;
    }


}

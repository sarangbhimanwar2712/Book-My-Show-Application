package com.example.book_my_show.Controllers;

import com.example.book_my_show.EntryDTOs.ShowEntryDto;
import com.example.book_my_show.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    ShowService showService ;

    @PostMapping("/add")
    public ResponseEntity<String > addShow (@RequestBody ShowEntryDto showEntryDto){
        try{
            String response = showService.addShow(showEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED) ;

        }catch (Exception e){
            String res = "Show could not be added" ;
            return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST );
        }
    }
}

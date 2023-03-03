package com.example.book_my_show.EntryDTOs;

import com.example.book_my_show.Enums.Genre;
import com.example.book_my_show.Enums.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntryDto {

    private String movieName ;
    private double rating ;
    private int duration ;

    private Language language ;

    private Genre genre ;

}

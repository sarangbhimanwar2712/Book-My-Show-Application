package com.example.book_my_show.EntryDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TheatreEntryDto {

    //Attributes required ;
    private String name ;
    private String location ;
    private int classicSeatsCount ;
    private int premiumSeatsCount ;
}

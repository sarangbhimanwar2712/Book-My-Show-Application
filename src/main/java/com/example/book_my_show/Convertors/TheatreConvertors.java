package com.example.book_my_show.Convertors;

import com.example.book_my_show.EntryDTOs.TheatreEntryDto;
import com.example.book_my_show.Models.Theatre;

public class TheatreConvertors {

    public static Theatre convertDtoToEntity(TheatreEntryDto theatreEntryDto){
        Theatre theatre = Theatre.builder().
                location(theatreEntryDto.getLocation()).
                name(theatreEntryDto.getName()).
                build();

        return theatre ;
    }
}

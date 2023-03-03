package com.example.book_my_show.Convertors;

import com.example.book_my_show.EntryDTOs.ShowEntryDto;
import com.example.book_my_show.Models.Show;

public class ShowConvertors {

    public static Show convertDtoToEntity(ShowEntryDto showEntryDto){
        Show show = Show.builder().
                showDate(showEntryDto.getLocalDate()).
                showTime(showEntryDto.getLocalTime()).
                showType(showEntryDto.getShowType()).
                build();

        return show ;
    }
}

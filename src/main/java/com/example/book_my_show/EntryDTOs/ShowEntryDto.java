package com.example.book_my_show.EntryDTOs;

import com.example.book_my_show.Enums.ShowType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowEntryDto {

    private LocalDate localDate;
    private LocalTime localTime;
    private ShowType showType;
    private int movieId;
    private int theatreId;
    private int classicSeatPrice;
    private int premiumSeatPrice;

}
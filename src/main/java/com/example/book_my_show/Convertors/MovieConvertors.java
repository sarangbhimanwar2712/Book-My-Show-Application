package com.example.book_my_show.Convertors;

import com.example.book_my_show.EntryDTOs.MovieEntryDto;
import com.example.book_my_show.Models.Movie;

public class MovieConvertors {

    public static Movie convertEntryDtoToEntity(MovieEntryDto movieEntryDto){

        Movie movie = Movie.builder().
                duration(movieEntryDto.getDuration()).
                rating(movieEntryDto.getRating()).
                movieName(movieEntryDto.getMovieName()).
                language(movieEntryDto.getLanguage()).
                genre(movieEntryDto.getGenre()).
                build() ;

        return movie ;
    }
}

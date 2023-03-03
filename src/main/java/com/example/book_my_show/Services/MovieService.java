package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.MovieConvertors;
import com.example.book_my_show.EntryDTOs.MovieEntryDto;
import com.example.book_my_show.Models.Movie;
import com.example.book_my_show.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {


    @Autowired
    MovieRepository movieRepository ;

    public String addMovie(MovieEntryDto movieEntryDto) throws Exception{

            Movie movie = MovieConvertors.convertEntryDtoToEntity(movieEntryDto) ; //calls convertor method
            movieRepository.save(movie) ;
            return "Movie added successfully" ;
    }
}

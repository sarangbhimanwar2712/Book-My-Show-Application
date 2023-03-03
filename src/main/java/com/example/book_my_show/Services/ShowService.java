package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.ShowConvertors;
import com.example.book_my_show.EntryDTOs.ShowEntryDto;
import com.example.book_my_show.Enums.SeatType;
import com.example.book_my_show.Models.*;
import com.example.book_my_show.Repositories.MovieRepository;
import com.example.book_my_show.Repositories.ShowRepository;
import com.example.book_my_show.Repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepository movieRepository ;

    @Autowired
    TheatreRepository theatreRepository ;

    @Autowired
    ShowRepository showRepository ;
    public String addShow (ShowEntryDto showEntryDto){

        //1. creating /converting entrydto to entity
        Show show = ShowConvertors.convertDtoToEntity(showEntryDto) ;

        int movieId = showEntryDto.getMovieId();
        int theatreId = showEntryDto.getTheatreId() ;

        Movie movie = movieRepository.findById(movieId).get() ;
        Theatre theatre = theatreRepository.findById(theatreId).get() ;

        //Setting the attributes of foreign key
        show.setMovie(movie);
        show.setTheatre(theatre);

       //pending  attributes the listOfShowSeatEntity

        List<Show_seat> seatList = createShowSeatEntity(showEntryDto,show) ;
        show.setShowSeats(seatList);


        //Now we also need to update the parent entities

        show = showRepository.save(show) ;

//        List<Show> showList = movie.getShowList() ; //getting it
//        showList.add(show) ;                        //adding it
//        movie.setShowList(showList);                // setting it
//        movieRepository.save(movie) ;               //saving it back /updating it back
        movie.getShowList().add(show) ;
        movieRepository.save(movie) ;

        theatre.getShowList().add(show) ;
        theatreRepository.save(theatre) ;
//        List<Show> showList1 = theatre.getShowList() ; //getting it
//        showList1.add(show);                          //adding it
//        theatre.setShowList(showList1);               // setting it
//        theatreRepository.save(theatre) ;              //saving /updating it back

        return "The show has been added successfully" ;
    }

    private List<Show_seat> createShowSeatEntity(ShowEntryDto showEntryDto ,Show show){

        //Now the goal is to create the showSeat entity
        //we need to set its attributes

        Theatre theatre = show.getTheatre() ;

        List<Theatre_seat> theatreSeatList = theatre.getListOfTheatreSeat();

        List<Show_seat> seatList = new ArrayList<>() ;

        for(Theatre_seat theatreSeat : theatreSeatList){

            Show_seat showSeat = new Show_seat() ;

            showSeat.setSeatNo(theatreSeat.getSeatNo());
            showSeat.setSeatType(theatreSeat.getSeatType()) ;


            if(theatreSeat.getSeatType().equals(SeatType.CLASSIC))
            {
                showSeat.setPrice(showEntryDto.getClassicSeatPrice());
            }
            else{
                showSeat.setPrice(showEntryDto.getPremiumSeatPrice());
            }

            showSeat.setBooked(false);
            showSeat.setShow(show); //parent : foreign key for showseat

            seatList.add(showSeat) ; //adding  it to the list
        }
        return seatList ;
    }
}

package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.TheatreConvertors;
import com.example.book_my_show.EntryDTOs.TheatreEntryDto;
import com.example.book_my_show.Enums.SeatType;
import com.example.book_my_show.Models.Theatre;
import com.example.book_my_show.Models.Theatre_seat;
import com.example.book_my_show.Repositories.TheatreRepository;
import com.example.book_my_show.Repositories.TheatreSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    TheatreSeatRepository theatreSeatRepository ;

    @Autowired
    TheatreRepository theatreRepository ;

    public String addTheatre(TheatreEntryDto theatreEntryDto) throws Exception {

        /*
         1.create theatre seats
         2. I need to save the theatre -->  I need  theatreEntity
         3. Always set attributes before saving .
         */
        if(theatreEntryDto.getName()==null||theatreEntryDto.getLocation()==null){
            throw new Exception("Name and location should valid");
        }

        Theatre theatre = TheatreConvertors.convertDtoToEntity(theatreEntryDto) ;
        List<Theatre_seat> theatreSeatList = createTheatreSeat(theatreEntryDto,theatre) ;

        theatre.setListOfTheatreSeat(theatreSeatList);
        theatreRepository.save(theatre) ;

        return "Theatre added successfully" ;

    }

    private List<Theatre_seat> createTheatreSeat(TheatreEntryDto theatreEntryDto,Theatre theatre){

         int  noOfClassicSeats = theatreEntryDto.getClassicSeatsCount();
         int noOfPremiumSeats = theatreEntryDto.getPremiumSeatsCount() ;

         List<Theatre_seat> theatreSeatList = new ArrayList<>() ;

         //Creating classic seats
         for(int count =1 ;count <=noOfClassicSeats ;count++){

             //We need to make a new  theatreseat

             Theatre_seat theatreSeat = Theatre_seat.builder().seatType(SeatType.CLASSIC).theatre(theatre).
                     seatNo(String.valueOf(count)+"C").build() ;

             theatreSeatList.add(theatreSeat) ;
         }

         //creating premium seats
        for(int count =1 ;count<=noOfPremiumSeats ;count++){
            Theatre_seat theatreSeat = Theatre_seat.builder().seatType(SeatType.PREMIUM).theatre(theatre).
                    seatNo(String.valueOf(count)+"C").build() ;

            theatreSeatList.add(theatreSeat) ;
        }
        return theatreSeatList ;
    }

    public List<Theatre> getAllTheatre(){
        List<Theatre> theatreList = theatreRepository.findAll() ;

        return theatreList ;
    }
}

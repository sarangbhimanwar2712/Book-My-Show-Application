package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.TicketConvertor;
import com.example.book_my_show.EntryDTOs.TicketEntryDto;
import com.example.book_my_show.Models.Show;
import com.example.book_my_show.Models.Show_seat;
import com.example.book_my_show.Models.Ticket;
import com.example.book_my_show.Models.User;
import com.example.book_my_show.Repositories.ShowRepository;
import com.example.book_my_show.Repositories.TicketRepository;
import com.example.book_my_show.Repositories.UserRepository;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository ;

    @Autowired
    ShowRepository showRepository ;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    UserRepository userRepository ;
    public  String addTicket(TicketEntryDto ticketEntryDto) throws Exception {
        //1. Create ticket entity from ticketEntryDto
        Ticket ticket = TicketConvertor.convertEntryDtoToEntity(ticketEntryDto) ;

        //validation : check if the request seats are available or not ?
        boolean isValidRequest = checkValidityOfRequestedSeats(ticketEntryDto) ;

        //If our validation comes false then we will throw exception that our requested seats are not available
        if(isValidRequest==false){
            throw new Exception("Requested seats are not available") ;
        }

        // We are here that means --> requestedSeats are valid

        //calculate the total amount
        Show show = showRepository.findById(ticketEntryDto.getShowId()).get() ;
        List<Show_seat> seatList = show.getShowSeats();
        List<String> requestedSeats = ticketEntryDto.getRequestedSeats() ;

        int totalAmount = 0 ;
        for(Show_seat showSeat : seatList){

            if(requestedSeats.contains(showSeat.getSeatNo())){
                totalAmount = totalAmount + showSeat.getPrice() ;
                showSeat.setBooked(true);
                showSeat.setBookedAt(new Date());
            }
        }
        ticket.setTotalAmount(totalAmount);

        //Setting the other attributes for the ticketEntity
        ticket.setMovieName(show.getMovie().getMovieName());
        ticket.setShowDate(show.getShowDate());
        ticket.setShowTime(show.getShowTime());
        ticket.setTheatreName(show.getTheatre().getName());

        //We need to set that string that talked about requested seats
        String allotedSeats = getAllotedSeatsFromShowSeats(requestedSeats) ;
        ticket.setBookedSeats(allotedSeats);

        //Setting the foreign key attributes
        User user = userRepository.findById(ticketEntryDto.getUserId()).get();

        ticket.setUser(user);
        ticket.setShow(show);

        //Save the parent

        ticket = ticketRepository.save(ticket) ;

        List<Ticket> ticketList = show.getTicketList();
        ticketList.add(ticket) ;
        show.setTicketList(ticketList);

        showRepository.save(show) ;

        List<Ticket> ticketList1 = user.getListOfbookedTickets() ;
        ticketList1.add(ticket) ;
        user.setListOfbookedTickets(ticketList1);

        userRepository.save(user) ;

        //Email
        String body = "Hi this is to confirm your booking for seat No "
                +allotedSeats +"for the movie : " + ticket.getMovieName() +" maje kr bhai ....!!!!";


        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("sarangbhimanwar02@gmail.com");
        mimeMessageHelper.setTo(user.getEmail());
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject("Confirming your booked Ticket");

        javaMailSender.send(mimeMessage);

        return "Ticket has been successfully  added" ;
    }

    private String getAllotedSeatsFromShowSeats(List<String> requestedSeats){
        String result ="" ;
        //Converting list of seats to string which is separated by comma
        for(String seat : requestedSeats){
            result = result + seat+ ", " ;
        }

        return result ;
    }

    private boolean checkValidityOfRequestedSeats(TicketEntryDto ticketEntryDto){

        int showId = ticketEntryDto.getShowId();
        Show show = showRepository.findById(showId).get() ;
        //Requested seats from user
        List<String> requestedSeats = ticketEntryDto.getRequestedSeats() ;

        //getting total seats for that particular show
        List<Show_seat> listOfSeats = show.getShowSeats() ;

        //Iterating over the list of seats for that particular
        for(Show_seat showSeat1 : listOfSeats){

            String seatNo = showSeat1.getSeatNo() ;
            if(requestedSeats.contains(seatNo)){

                if(showSeat1.isBooked()==true){
                    return false ;//Since this seat is already occupied : returning false--> we can't book is this seat
                }
            }
        }
        //At any condition our iteration comes here then all our requested seats are available then we will return true
        return true ;
    }
}

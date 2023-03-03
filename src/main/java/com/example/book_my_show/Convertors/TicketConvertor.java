package com.example.book_my_show.Convertors;

import com.example.book_my_show.EntryDTOs.TicketEntryDto;
import com.example.book_my_show.Models.Ticket;

public class TicketConvertor {

    public static Ticket convertEntryDtoToEntity(TicketEntryDto ticketEntryDto){
        Ticket ticket = new Ticket() ;
        return ticket ;
    }
}

package com.example.book_my_show.Models;

import jakarta.persistence.* ;
import lombok.*;


import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private int totalAmount ;
    private String movieName ;
    private LocalTime showTime ;

    private LocalDate showDate ;
    private String theatreName ;
    private String ticketID = UUID.randomUUID().toString();

    private String bookedSeats ;


    //ticket is child wrt to user
    @ManyToOne
    @JoinColumn
    private User user;

    //ticket is child wrt to show
    @ManyToOne
    @JoinColumn
    private Show show ;
}

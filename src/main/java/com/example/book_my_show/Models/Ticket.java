package com.example.book_my_show.Models;

import jakarta.persistence.*;
import lombok.*;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private int price ;
    private String movieName ;
    private Time showTime ;

    private Date showDate ;
    private String theatreName ;
    private List<Show> bookedSeats;

    //ticket is child wrt to user
    @ManyToOne
    @JoinColumn
    private User user;

    //ticket is child wrt to show
    @ManyToOne
    @JoinColumn
    private Show show ;
}

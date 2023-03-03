package com.example.book_my_show.Models;

import com.example.book_my_show.Enums.SeatType;
import jakarta.persistence.* ;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "show_seat")
//@Getter
//@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Show_seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private boolean isBooked ;
    private int price ;
    private String seatNo ;
    private Date bookedAt ;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType ;

    //show_seat is child wrt show
    @ManyToOne
    @JoinColumn
    private Show show ;


}

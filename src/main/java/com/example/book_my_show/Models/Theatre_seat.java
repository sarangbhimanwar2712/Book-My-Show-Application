package com.example.book_my_show.Models;

import com.example.book_my_show.Enums.SeatType;
import jakarta.persistence.* ;
import lombok.*;

@Entity
@Table(name = "theatre_seat")
//@Getter  //+
//@Setter  //---> @Data
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Theatre_seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String seatNo ;
    private SeatType seatType ;


    //theatre_seat is child wrt theatre
    @ManyToOne
    @JoinColumn
    private Theatre theatre ;


}

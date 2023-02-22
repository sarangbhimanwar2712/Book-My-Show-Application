package com.example.book_my_show.Models;

import com.example.book_my_show.Enums.ShowType;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "show")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private LocalDate showDate ;
    private LocalTime showTime ;
    @Enumerated(value = EnumType.STRING)
    private ShowType showType ;

    @CreationTimestamp
    private Date createdOn ;

    @UpdateTimestamp
    private Date updatedOn ;

    //show is parent wrt ticket
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();

    //show is parent wrt showseat
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Show_seat> showSeats =new ArrayList<>() ;

    //show is child wrt movie
    @ManyToOne
    @JoinColumn
    private Movie movie ;

    //show is child wrt theatre
    @ManyToOne
    @JoinColumn
    private Theatre theatre ;
}

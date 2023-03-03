package com.example.book_my_show.Models;

import jakarta.persistence.* ;
import lombok.*;

import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theatre")
//@Getter
//@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name ;
    private String location ;

    //theatre is parent wrt show
    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    List<Show> showList = new ArrayList<>();

    //theatre is parent wrt theatre_seat
    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<Theatre_seat> ListOfTheatreSeat =new ArrayList<>();
}

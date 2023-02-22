package com.example.book_my_show.Models;

import com.example.book_my_show.Enums.Genre;
import com.example.book_my_show.Enums.Language;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "movie")
//@Getter //+
//@Setter //--> @Data
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(unique = true,nullable = false)
    private String movieName ;
    private double rating ;
    private int duration ;
    @Enumerated(value = EnumType.STRING)
    private Language language ;

    @Enumerated(value = EnumType.STRING)
    private Genre genre ;

    //Movie is parent wrt show
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Show> showList ;
}

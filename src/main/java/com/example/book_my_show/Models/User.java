package com.example.book_my_show.Models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user")
//@Getter
//@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name ;
    @Column(unique = true,nullable = false)
    private String email ;
    private int age ;
    @Column(unique = true,nullable = false)
    private int mobNo ;
    private String address ;

    //User is parent for Ticket entity
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Ticket> bookedTickets ;


}

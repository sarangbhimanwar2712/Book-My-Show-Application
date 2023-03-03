package com.example.book_my_show.Repositories;

import com.example.book_my_show.Models.Theatre;
import com.example.book_my_show.Models.Theatre_seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatRepository extends JpaRepository<Theatre_seat,Integer> {
}

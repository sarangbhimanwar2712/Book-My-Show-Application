package com.example.book_my_show.Repositories;

import com.example.book_my_show.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}

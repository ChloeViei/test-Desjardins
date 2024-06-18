package com.desjardins.test_backend.repository;

import com.desjardins.test_backend.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}

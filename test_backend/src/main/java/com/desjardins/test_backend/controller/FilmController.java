package com.desjardins.test_backend.controller;

import com.desjardins.test_backend.dto.FilmDto;
import com.desjardins.test_backend.entity.Film;
import com.desjardins.test_backend.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/film")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        return ResponseEntity.ok(filmService.getFilmById(id));
    }

    @PostMapping
    public ResponseEntity<Film> createFilm(@Valid @RequestBody FilmDto film) {
        Film savedFilm = filmService.saveFilm(film);
        return ResponseEntity.status(201).body(savedFilm);
    }
}

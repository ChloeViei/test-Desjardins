package com.desjardins.test_backend.service;

import com.desjardins.test_backend.dto.FilmDto;
import com.desjardins.test_backend.entity.Film;
import com.desjardins.test_backend.exception.film.FilmNotFoundException;
import com.desjardins.test_backend.mapper.FilmMapper;
import com.desjardins.test_backend.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FilmService {

    private FilmRepository filmRepository;
    private FilmMapper filmMapper;

    public Film getFilmById(Long id) {
        return filmRepository.findById(id)
                .orElseThrow(() -> new FilmNotFoundException("Film not found with id : " + id));
    }

    public Film saveFilm(FilmDto film) {
        return filmRepository.save(filmMapper.fromDto(film));
    }
}

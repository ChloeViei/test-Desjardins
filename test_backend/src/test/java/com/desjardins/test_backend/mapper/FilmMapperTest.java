package com.desjardins.test_backend.mapper;

import com.desjardins.test_backend.dto.ActeurDto;
import com.desjardins.test_backend.dto.FilmDto;
import com.desjardins.test_backend.entity.Acteur;
import com.desjardins.test_backend.entity.Film;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FilmMapperTest {

    private final FilmMapper filmMapper = Mappers.getMapper(FilmMapper.class);

    @Test
    public void testFromDto() {
        // Arrange
        ActeurDto acteurDto = new ActeurDto("John", "Doe");
        List<ActeurDto> acteurDtos = Arrays.asList(acteurDto);
        FilmDto filmDto = new FilmDto("Test Title", "Test Description", acteurDtos);

        // Act
        Film film = filmMapper.fromDto(filmDto);

        // Assert
        assertNotNull(film);
        assertEquals(filmDto.titre(), film.getTitre());
        assertEquals(filmDto.description(), film.getDescription());
        assertNotNull(film.getActeurs());
        assertEquals(filmDto.acteurs().size(), film.getActeurs().size());
        assertEquals(filmDto.acteurs().get(0).nom(), film.getActeurs().get(0).getNom());
        assertEquals(filmDto.acteurs().get(0).prenom(), film.getActeurs().get(0).getPrenom());
    }

    @Test
    public void testToDto() {
        // Arrange
        Acteur acteur = new Acteur();
        acteur.setNom("John");
        acteur.setPrenom("Doe");
        List<Acteur> acteurs = Arrays.asList(acteur);
        Film film = new Film();
        film.setTitre("Test Title");
        film.setDescription("Test Description");
        film.setActeurs(acteurs);

        // Act
        FilmDto filmDto = filmMapper.toDto(film);

        // Assert
        assertNotNull(filmDto);
        assertEquals(film.getTitre(), filmDto.titre());
        assertEquals(film.getDescription(), filmDto.description());
        assertNotNull(filmDto.acteurs());
        assertEquals(film.getActeurs().size(), filmDto.acteurs().size());
        assertEquals(film.getActeurs().get(0).getNom(), filmDto.acteurs().get(0).nom());
        assertEquals(film.getActeurs().get(0).getPrenom(), filmDto.acteurs().get(0).prenom());
    }
}

package com.desjardins.test_backend.mapper;

import com.desjardins.test_backend.dto.FilmDto;
import com.desjardins.test_backend.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface FilmMapper {

    @Mapping(target = "titre", source = "titre")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "id", ignore = true)
    Film fromDto(FilmDto dto);

    @Mapping(target = "titre", source = "titre")
    @Mapping(target = "description", source = "description")
    FilmDto toDto(Film entity);
}

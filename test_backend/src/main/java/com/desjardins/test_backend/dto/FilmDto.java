package com.desjardins.test_backend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record FilmDto(
        @NotEmpty String titre,
        String description,
        List<ActeurDto> acteurs) {
}

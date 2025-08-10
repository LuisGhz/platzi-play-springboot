package dev.luisghtz.platzi_play.domain.dto;

import dev.luisghtz.platzi_play.domain.Genre;

import java.time.LocalDate;

public record UpdateMovieDto(
        String title,
        LocalDate releaseDate,
        Double rating
) {
}

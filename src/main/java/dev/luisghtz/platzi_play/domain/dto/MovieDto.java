package dev.luisghtz.platzi_play.domain.dto;

import dev.luisghtz.platzi_play.domain.Genre;

import java.time.LocalDate;

public record MovieDto(
        Long id,
        String title,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating,
        Boolean status
) {
}

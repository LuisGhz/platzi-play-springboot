package dev.luisghtz.platzi_play.domain.dto;

import dev.luisghtz.platzi_play.domain.Genre;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record UpdateMovieDto(
        @NotBlank(message = "Title cannot be blank")
        String title,
        @PastOrPresent(message = "Release date must be in the past or present")
        LocalDate releaseDate,
        @Min(value = 0, message = "Rating can not be less than 0")
        @Min(value = 5, message = "Rating can not be greater than 5")
        Double rating
) {
}

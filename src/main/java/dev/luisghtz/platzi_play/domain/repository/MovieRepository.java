package dev.luisghtz.platzi_play.domain.repository;

import dev.luisghtz.platzi_play.domain.dto.MovieDto;
import dev.luisghtz.platzi_play.domain.dto.UpdateMovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(Long id);
    MovieDto create(MovieDto movieDto);
    MovieDto update(Long id, UpdateMovieDto movieDto);
    void delete(Long id);
}

package dev.luisghtz.platzi_play.domain.repository;

import dev.luisghtz.platzi_play.domain.dto.MovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
}

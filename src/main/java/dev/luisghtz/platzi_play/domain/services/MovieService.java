package dev.luisghtz.platzi_play.domain.services;

import dev.luisghtz.platzi_play.domain.dto.MovieDto;
import dev.luisghtz.platzi_play.domain.dto.UpdateMovieDto;
import dev.luisghtz.platzi_play.persistence.MovieEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieEntityRepository movieRepository;

    public List<MovieDto> getAll() {
        return movieRepository.getAll();
    }

    public MovieDto getById(Long id) {
        return movieRepository.getById(id);
    }

    public MovieDto create(MovieDto movieDto) {
        return movieRepository.create(movieDto);
    }

    public MovieDto update(Long id, UpdateMovieDto movieDto) {
        return movieRepository.update(id, movieDto);
    }

    public void delete(Long id) {
        movieRepository.delete(id);
    }
}

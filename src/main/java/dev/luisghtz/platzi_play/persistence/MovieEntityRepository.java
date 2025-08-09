package dev.luisghtz.platzi_play.persistence;

import dev.luisghtz.platzi_play.domain.dto.MovieDto;
import dev.luisghtz.platzi_play.domain.repository.MovieRepository;
import dev.luisghtz.platzi_play.persistence.crud.CrudMovieEntity;
import dev.luisghtz.platzi_play.persistence.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovieEntityRepository implements MovieRepository {
    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDto> getAll() {
        return movieMapper.toDtoList(
                crudMovieEntity.findAll()
        );
    }
}

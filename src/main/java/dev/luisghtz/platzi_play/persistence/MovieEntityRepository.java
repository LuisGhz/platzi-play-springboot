package dev.luisghtz.platzi_play.persistence;

import dev.luisghtz.platzi_play.domain.dto.MovieDto;
import dev.luisghtz.platzi_play.domain.dto.UpdateMovieDto;
import dev.luisghtz.platzi_play.domain.exception.MovieAlreadyExistsException;
import dev.luisghtz.platzi_play.domain.repository.MovieRepository;
import dev.luisghtz.platzi_play.persistence.crud.CrudMovieEntity;
import dev.luisghtz.platzi_play.persistence.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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

    @Override
    public MovieDto getById(Long id) {
        return movieMapper.toDto(
                crudMovieEntity.findById(id).orElse(null)
        );
    }

    @Override
    public MovieDto create(MovieDto movieDto) {

        if (crudMovieEntity.findFirstByTitulo(movieDto.title()) != null) {
            throw new MovieAlreadyExistsException(movieDto.title());
        }
        var movieEntity = movieMapper.toEntity(movieDto);
        return movieMapper.toDto(
                crudMovieEntity.save(movieEntity)
        );
    }

    @Override
    public MovieDto update(Long id, UpdateMovieDto movieDto) {
        var entity = crudMovieEntity.findById(id).orElse(null);

        if (entity == null) {
            return null;
        }

        movieMapper.updateEntityFromDto(movieDto, entity);

        return movieMapper.toDto(
                crudMovieEntity.save(entity)
        );
    }

    @Override
    public void delete(Long id) {
        crudMovieEntity.deleteById(id);
    }
}

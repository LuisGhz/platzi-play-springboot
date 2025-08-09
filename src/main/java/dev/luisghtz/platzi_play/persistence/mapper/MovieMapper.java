package dev.luisghtz.platzi_play.persistence.mapper;

import dev.luisghtz.platzi_play.domain.dto.MovieDto;
import dev.luisghtz.platzi_play.persistence.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mappings(
            value = {
                    @Mapping(source = "titulo", target = "title"),
                    @Mapping(source = "duracion", target = "duration"),
                    @Mapping(source = "genero", target = "genre"),
                    @Mapping(source = "fechaEstreno", target = "releaseDate"),
                    @Mapping(source = "clasificacion", target = "rating")
            }

    )
    MovieDto toDto(MovieEntity movieEntity);
    List<MovieDto> toDtoList(Iterable<MovieEntity> movieEntities);
}

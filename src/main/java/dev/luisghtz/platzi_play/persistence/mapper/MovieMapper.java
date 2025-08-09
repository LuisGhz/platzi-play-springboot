package dev.luisghtz.platzi_play.persistence.mapper;

import dev.luisghtz.platzi_play.domain.dto.MovieDto;
import dev.luisghtz.platzi_play.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class, StateMapper.class})
public interface MovieMapper {

    @Mappings(
            value = {
                    @Mapping(source = "titulo", target = "title"),
                    @Mapping(source = "duracion", target = "duration"),
                    @Mapping(source = "genero", target = "genre", qualifiedByName = "stringToGenre"),
                    @Mapping(source = "fechaEstreno", target = "releaseDate"),
                    @Mapping(source = "clasificacion", target = "rating"),
                    @Mapping(source = "estado", target = "status", qualifiedByName = "stringToBoolean")
            }

    )
    MovieDto toDto(MovieEntity movieEntity);

    List<MovieDto> toDtoList(Iterable<MovieEntity> movieEntities);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "status", target = "estado", qualifiedByName = "booleanToString"),
            @Mapping(source = "genre", target = "genero", qualifiedByName = "genreToString"),
    })
    MovieEntity toEntity(MovieDto movieDto);
}

package dev.luisghtz.platzi_play.web.controllers;

import dev.luisghtz.platzi_play.domain.dto.MovieDto;
import dev.luisghtz.platzi_play.domain.dto.SuggestRequestDto;
import dev.luisghtz.platzi_play.domain.dto.UpdateMovieDto;
import dev.luisghtz.platzi_play.domain.services.MovieService;
import dev.luisghtz.platzi_play.domain.services.PlatziPlayAIService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
@Tag(name = "Movies", description = "Operations related to movies")
public class MovieController {
    private final MovieService movieService;
    private final PlatziPlayAIService platziPlayAIService;

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @Operation(
            summary = "Get movie by ID",
            description = "Retrieve a movie by its unique identifier",
            responses = {
                    @ApiResponse(description = "Movie found", responseCode = "200"),
                    @ApiResponse(description = "Movie not found", responseCode = "404", content = @Content)
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@Parameter(name = "id", description = "Movie id", example = "9") @PathVariable Long id) {
        var entity = movieService.getById(id);
        return entity != null
                ? ResponseEntity.ok(entity)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MovieDto> create(@RequestBody MovieDto movieDto) {
        var savedMovie = movieService.create(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }

    @PostMapping("/suggestion")
    public ResponseEntity<String> createSuggestions(@RequestBody SuggestRequestDto dto) {
        return ResponseEntity.ok(
                platziPlayAIService.generateMoviesSuggestions(dto.userPreference())
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable Long id, @Valid @RequestBody UpdateMovieDto movieDto) {
        var updatedMovie = movieService.update(id, movieDto);
        return updatedMovie != null
                ? ResponseEntity.ok(updatedMovie)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
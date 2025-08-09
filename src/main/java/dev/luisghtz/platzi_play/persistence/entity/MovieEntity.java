package dev.luisghtz.platzi_play.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "platzi_play_peliculas")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150, unique = true)
    private String titulo;
    @Column(nullable = false, precision = 3)
    private Integer duracion;
    @Column(nullable = false, length = 40)
    private String genero;
    @Column(name = "fecha_estreno")
    private LocalDate fechaEstreno;
    @Column(precision = 3, scale = 2)
    private BigDecimal clasificacion;
    @Column(nullable = false, length = 1)
    private String estado;
}

package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa una película
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {
    private Integer id;
    private String titulo;
    private String genero;
    private Integer anio;

    public Pelicula(String titulo, int anio, String genero) {
        this.titulo = titulo;
        this.anio = anio;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "ID:" + id + ", Titulo: " + titulo + ", Género: " + genero + ", Año: " + anio;
    }
}

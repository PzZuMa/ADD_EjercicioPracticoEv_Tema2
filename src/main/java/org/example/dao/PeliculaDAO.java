package org.example.dao;

import org.example.model.Pelicula;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para manipular e interactuar con la tabla Pelicula de la Base de Datos.
 */
public class PeliculaDAO implements DAO<Pelicula>{
    private static Connection connection = null;

    private static final String INSERT_INTO_PELICULA = "INSERT INTO pelicula (titulo, año, genero) values (?,?,?);";

    public PeliculaDAO(Connection conn) {
        this.connection = conn;
    }

    /**
     * Inserta una pelicula en la base de datos.
     * @param pelicula
     */
    @Override
    public void insert(Pelicula pelicula) {
        try (var ps = connection.prepareStatement(INSERT_INTO_PELICULA)) {
            ps.setString(1, pelicula.getTitulo());
            ps.setInt(2, pelicula.getAnio());
            ps.setString(3, pelicula.getGenero());
            ps.executeUpdate();
            System.out.println("Pelicula "+pelicula.getTitulo()+" insertada correctamente.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Pelicula pelicula) {

    }

    @Override
    public void delete(Integer pelicula) {

    }

    @Override
    public Pelicula get(int id) {
        return null;
    }

    @Override
    public Pelicula[] getAll() {
        return new Pelicula[0];
    }

    /**
     * Obtiene el numero de peliculas en la base de datos.
     * @return
     */
    @Override
    public Integer count() {
        Integer resultado = 0;

        try (var ps = connection.prepareStatement("SELECT COUNT(*) FROM pelicula;")) {
            var rs = ps.executeQuery();
            if (rs.next()) {
                resultado = rs.getInt(1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    /**
     * Filtra las peliculas por genero.
     * @param genero
     * @return
     */
    @Override
    public List<Pelicula> filter(String genero) {
        ArrayList<Pelicula> resultado = new ArrayList<>();

        try (var ps = connection.prepareStatement("SELECT * FROM pelicula WHERE genero = ?;")) {
            ps.setString(1, genero);
            var rs = ps.executeQuery();
            while (rs.next()) {
                resultado.add(new Pelicula(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getInt(3)
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }


}

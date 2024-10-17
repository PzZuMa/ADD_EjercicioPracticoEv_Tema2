package org.example;

import org.example.dao.JDBC_Utils;
import org.example.dao.PeliculaDAO;
import org.example.model.Pelicula;

/**
 * Clase principal que ejecuta el programa
 */
public class Main {
    public static void main(String[] args) {
        PeliculaDAO peliDAO = new PeliculaDAO(JDBC_Utils.getConn());

        System.out.println("Hay un total de "+peliDAO.count()+" películas.");
        peliDAO.filter("drama").forEach(System.out::println);

        peliDAO.insert(new Pelicula("Titanic", 1997, "drama"));

        System.out.println("Hay un total de "+peliDAO.count()+" películas.");
        peliDAO.filter("drama").forEach(System.out::println);
    }
}
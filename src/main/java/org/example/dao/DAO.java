package org.example.dao;

import java.util.List;

/**
 * Clase para manipular e interacturar con la base de datos de la aplicacion.
 * @param <T>
 */
public interface DAO <T> {
    void insert(T t);
    void update(T t);
    void delete(Integer id);
    T get(int id);
    T[] getAll();
    Integer count();
    List<T> filter(String genero);
}

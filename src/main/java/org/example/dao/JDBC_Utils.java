package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para manejar la conexion a la base de datos.
 */
public class JDBC_Utils {
    private static Connection conn;

    static{
        String url = "jdbc:mysql://localhost:3306/EPE_Tema2_BD";
        String user = "root";
        String password = System.getenv("MYSQL_ROOT_PASSWORD");
        try {
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        JDBC_Utils.conn = conn;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ctorres.leerarchivoxml.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";

    private static final String JDBC_SERVER_NAME = "elmer.db.elephantsql.com";
    private static final String JBDC_DATABASE_NAME = "dliwqbdg";
    //"jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
    private static final String JDBC_URL = "jdbc:postgresql://" + JDBC_SERVER_NAME + "/" + JBDC_DATABASE_NAME + "?useSSL=false";
    //private static final String JDBC_URL = "jdbc:mysql://" + JDBC_SERVER_NAME + "/" + JBDC_DATABASE_NAME + "?useSSL=false";
    private static final String JDBC_USER = "dliwqbdg";
    private static final String JDBC_PASS = "d8OJSmrxGTiPFEAbTvlemFJIRKbWIIMy";
    private static Driver driver = null;

    //Para que no haya problemas al obtener la conexion de
    //manera concurrente, se usa la palabra synchronized
    public synchronized Connection obtenerConexion()
            throws SQLException {

        if (driver == null) {
            try {
                //Se registra el driver
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);

            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
                System.out.println("Fallo en cargar el driver JDBC");
                e.printStackTrace(System.out);
            }
        }
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }

    //Cierre del resultSet
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
    }

    //Cierre del PrepareStatement
    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
    }

    //Cierre de la conexion
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
    }

}

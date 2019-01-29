/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensource.practica2.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class Consultas {

    private static final String SELECT_ESTUDIANTES = "SELECT * FROM Estudiante";

    public static ResultSet Estudiantes() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(SELECT_ESTUDIANTES);
            rs = ps.executeQuery();

        } catch (SQLException e) {

            e.printStackTrace(System.out);
        } finally {
            MyConnection.close(conn);
        }

        return rs;
    }

}

package com.ctorres.leerarchivoxml;

import com.ctorres.leerarchivoxml.connection.Conexion;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CrearXml {

    public static void main(String args[]) throws org.xml.sax.SAXException, SQLException {

        try {
            File archivo = new File(JOptionPane.showInputDialog("Ruta del archivo: "));
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            document.getDocumentElement().normalize();
            NodeList listaEmpleados = document.getElementsByTagName("estudiante");

            for (int temp = 0; temp < listaEmpleados.getLength(); temp++) {
                Node nodo = listaEmpleados.item(temp);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;

                    int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                    String cedula = element.getElementsByTagName("cedula").item(0).getTextContent();
                    String matricula = element.getElementsByTagName("matricula").item(0).getTextContent();
                    String carrera = element.getElementsByTagName("carreraAbrev").item(0).getTextContent();
                    int creditos_totales = Integer.parseInt(element.getElementsByTagName("crdtsTotal").item(0).getTextContent());
                    int creditos_cursados = Integer.parseInt(element.getElementsByTagName("crdtsCursados").item(0).getTextContent());

                    insertarEstudiantes(id, cedula, matricula, carrera, creditos_totales, creditos_cursados);
                }
            }
        } catch (HeadlessException | IOException | ParserConfigurationException | DOMException e) {
        }
    }

    public static void insertarEstudiantes(int id, String cedula, String matricula, 
            String carrera, int creditosTotales, int creditosCursados) 
            throws SQLException {

        Conexion conn = new Conexion();
        PreparedStatement ps;

        Connection con = conn.obtenerConexion();
        try {
            ps = con.prepareStatement("insert into Estudiantes_Fundapec values (?,?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, cedula);
            ps.setString(3, matricula);
            ps.setString(4, carrera);
            ps.setInt(5, creditosTotales);
            ps.setInt(6, creditosCursados);

            int insertados = ps.executeUpdate();

            if (insertados > 0) {
                System.out.println("Registro insertado correctamente.");
            } else {
                System.out.println("Registro no insertado");
            }

        } catch (SQLException ex) {
        }

    }

}

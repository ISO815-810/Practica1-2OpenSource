package com.ctorres.leerarchivoxml;

import java.io.File;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CrearXml {
    
    public static void main(String args[]) {
    
        try {
            File archivo = new File(JOptionPane.showInputDialog("Ruta: "));
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            document.getDocumentElement().normalize();
            System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
            NodeList listaEmpleados = document.getElementsByTagName("estudiante");
            
            for (int temp = 0; temp < listaEmpleados.getLength(); temp++) {
                Node nodo = listaEmpleados.item(temp);
                System.out.println("Elemento:" + nodo.getNodeName());
                
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    System.out.println("id: " + element.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("cedula: " + element.getElementsByTagName("cedula").item(0).getTextContent());
                    System.out.println("matricula: " + element.getElementsByTagName("matricula").item(0).getTextContent());
                    System.out.println("creditos totales: " + element.getElementsByTagName("crdtsTotal").item(0).getTextContent());
                    System.out.println("creditos cursados: " + element.getElementsByTagName("crdtsCursados").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

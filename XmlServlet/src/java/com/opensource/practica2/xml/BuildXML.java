package com.opensource.practica2.xml;

import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author DELL
 */
public class BuildXML {

    /* printDOM will write the contents of xml document passed onto it out to a file*/
    public static void printDOM(Document _xmlDoc, File _outputFile)
            throws Exception {

        OutputFormat outputFormat = new OutputFormat("XML", "UTF-8", true);

        FileWriter fileWriter = new FileWriter(_outputFile);

        XMLSerializer xmlSerializer = new XMLSerializer(fileWriter, outputFormat);

        xmlSerializer.asDOMSerializer();

        xmlSerializer.serialize(_xmlDoc.getDocumentElement());
    }

    /*Build XML DOcument from database. The XML object is returned to main method where it is written to flat file.*/
    public static Document buildXML(ResultSet _studentRS)
            throws Exception {

        Document xmlDoc = new DocumentImpl();

        /* Creating the root element */
        //replace employeetable with countries to set a countries tag
        Element rootElement = xmlDoc.createElement("Estudiantes");
        xmlDoc.appendChild(rootElement);

        while (_studentRS.next()) {

            Element emp = xmlDoc.createElement("estudiante");
            //replace employee with country for country tag

            /* Build the CustomerId as a Attribute*/
            //emp.setAttribute("empid", _studentRS.getString("empid"));

            /* Creating elements within customer DOM*/
            Element studentId = xmlDoc.createElement("id");
            Element studentCedula = xmlDoc.createElement("cedula");
            Element studentMatricula = xmlDoc.createElement("matricula");
            Element studentCrdtsTotal = xmlDoc.createElement("crdtsTotal");
            Element studentCrdtsCursados = xmlDoc.createElement("crdtsCursados");

            /* Populating Customer DOM with Data*/
            studentId.appendChild(xmlDoc.createTextNode(_studentRS.getString("id")));
            studentCedula.appendChild(xmlDoc.createTextNode(_studentRS.getString("cedula")));
            studentMatricula.appendChild(xmlDoc.createTextNode(_studentRS.getString("matricula")));
            studentCrdtsTotal.appendChild(xmlDoc.createTextNode(_studentRS.getString("crdtsTotal")));
            studentCrdtsCursados.appendChild(xmlDoc.createTextNode(_studentRS.getString("crdtsCursados")));

            /* Adding the empname and role elements to the employee Element*/
            emp.appendChild(studentId);
            emp.appendChild(studentCedula);
            emp.appendChild(studentMatricula);
            emp.appendChild(studentCrdtsTotal);
            emp.appendChild(studentCrdtsCursados);

            /* Appending emp to the Root Class*/
            rootElement.appendChild(emp);
        }
        return xmlDoc;
    }
}

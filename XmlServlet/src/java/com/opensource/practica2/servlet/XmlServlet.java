/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensource.practica2.servlet;

import com.opensource.practica2.connection.Consultas;
import com.opensource.practica2.xml.BuildXML;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.w3c.dom.Document;

/**
 *
 * @author DELL
 */
@WebServlet(name = "XmlServlet", urlPatterns = {"/XmlServlet"})
public class XmlServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet XmlServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet XmlServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        if (request.getParameter("enviar") != null) {

            String _path = request.getParameter("ruta");
            String _outputFile = request.getParameter("archivo");

            String pathComplete = _path + _outputFile + ".xml";

            try {

                /**
                 * Step 1 : Build customer XML DOM
                 */
                Document xmlDoc = BuildXML.buildXML(Consultas.Estudiantes());

                /**
                 * Step 2: Write output to a file
                 */
                File outputFile = new File(pathComplete);
                BuildXML.printDOM(xmlDoc, outputFile);

            } catch (FileAlreadyExistsException | SQLException ex) {

                System.out.println("file alread present at this location");

                System.out.println("Really poor exception handling " + ex.toString());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

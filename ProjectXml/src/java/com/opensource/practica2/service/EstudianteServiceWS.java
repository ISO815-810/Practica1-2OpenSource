/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensource.practica2.service;

import com.opensource.practica2.domain.Estudiantes;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author DELL
 */
@WebService
public interface EstudianteServiceWS {

    @WebMethod
    public List<Estudiantes> listarEstudiantes();

    @WebMethod
    public Estudiantes encontrarEstudiantesPorId(Estudiantes estudiante);

//    @WebMethod
//    public Estudiantes encontrarEstudiantesPorMatricula(Estudiantes estudiante);

    @WebMethod
    public void registrarEstudiantes(Estudiantes estudiante);

    @WebMethod
    public void modificarEstudiantes(Estudiantes estudiante);

    @WebMethod
    public void eliminarEstudiantes(Estudiantes estudiante);

}

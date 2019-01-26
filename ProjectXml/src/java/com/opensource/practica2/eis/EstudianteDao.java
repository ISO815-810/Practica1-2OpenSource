/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensource.practica2.eis;

import java.util.List;
import com.opensource.practica2.domain.Estudiantes;

/**
 *
 * @author DELL
 */
public interface EstudianteDao {

    public List<Estudiantes> findAllEstudiantes();

    public Estudiantes findEstudiantesById(Estudiantes estudiante);

    public Estudiantes findEstudiantesByCedula(Estudiantes estudiante);
    
    public Estudiantes findEstudiantesByMatricula(Estudiantes estudiante);

    public void insertEstudiantes(Estudiantes estudiante);

    public void updateEstudiantes(Estudiantes estudiante);

    public void deleteEstudiantes(Estudiantes estudiante);
}

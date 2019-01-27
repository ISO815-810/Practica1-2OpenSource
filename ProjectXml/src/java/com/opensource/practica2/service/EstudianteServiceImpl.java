/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensource.practica2.service;

import com.opensource.practica2.domain.Estudiantes;
import com.opensource.practica2.eis.EstudianteDao;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface = "com.opensource.practica2.service.EstudianteServiceWS")
public class EstudianteServiceImpl implements EstudianteServiceWS {

    @Resource
    private SessionContext contexto;

    //Injectamos la referencia con esta anotacion
    @Inject
    private EstudianteDao estudianteDao;

    @Override
    public List<Estudiantes> listarEstudiantes() {
        return estudianteDao.findAllEstudiantes();
    }

    @Override
    public Estudiantes encontrarEstudiantesPorId(Estudiantes estudiante) {
        return estudianteDao.findEstudiantesById(estudiante);
    }

//    @Override
//    public Estudiantes encontrarEstudiantesPorMatricula(Estudiantes estudiante) {
//        return estudianteDao.findEstudiantesByMatricula(estudiante);
//    }

    @Override
    public void registrarEstudiantes(Estudiantes estudiante) {
        estudianteDao.insertEstudiantes(estudiante);
    }

    @Override
    public void modificarEstudiantes(Estudiantes estudiante) {
        try {
            estudianteDao.updateEstudiantes(estudiante);
        } catch (Exception e) {
            contexto.setRollbackOnly();
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarEstudiantes(Estudiantes estudiante) {
        estudianteDao.deleteEstudiantes(estudiante);
    }
}

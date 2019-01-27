/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensource.practica2.eis;

import com.opensource.practica2.domain.Estudiantes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EstudianteDaoImpl implements EstudianteDao {

    @PersistenceContext(unitName = "ProjectXmlPU")
    EntityManager em;

    @Override
    public List<Estudiantes> findAllEstudiantes() {
        return em.createNamedQuery("Estudiantes.findAll").getResultList();
    }

    @Override
    public Estudiantes findEstudiantesById(Estudiantes estudiante) {
        return em.find(Estudiantes.class, estudiante.getId());
    }

//    @Override
//    public Estudiantes findEstudiantesByMatricula(Estudiantes estudiante) {
//        Query query = em.createQuery("FROM Estudiantes e WHERE e.matriculaEstudiante = :matriculaEstudiante");
//        query.setParameter("matriculaEstudiante", estudiante.getMatriculaEstudiante());
//        return (Estudiantes) query.getSingleResult();
//        return em.find(Estudiantes.class, estudiante.getMatriculaEstudiante());
//    }
    @Override
    public void insertEstudiantes(Estudiantes estudiante) {
        em.persist(estudiante);
    }

    @Override
    public void updateEstudiantes(Estudiantes estudiante) {
        em.merge(estudiante);
    }

    @Override
    public void deleteEstudiantes(Estudiantes estudiante) {
        estudiante = em.getReference(Estudiantes.class, estudiante.getId());
        em.remove(estudiante);
    }
}

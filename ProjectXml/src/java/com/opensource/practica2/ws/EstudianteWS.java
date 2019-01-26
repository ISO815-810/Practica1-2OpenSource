/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensource.practica2.ws;

import com.opensource.practica2.domain.Estudiantes;
import com.opensource.practica2.service.EstudianteServiceWS;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author DELL
 */
@Path("/estudiantes")
@Stateless
public class EstudianteWS {

    @Inject
    private EstudianteServiceWS estudianteService;

    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudiantes> listarEstudiante() {
        return estudianteService.listarEstudiantes();
    }

    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")//esto hace referencia a /estudiantes/{id}
    public Estudiantes encontrarEstudiantePorId(@PathParam("id") int id) {
        return estudianteService.encontrarEstudiantesPorId(new Estudiantes(id));
    }

    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{cedulaEstudiante}")//esto hace referencia a /estudiantes/{cedulaEstudiante}
    public Estudiantes encontrarEstudiantePorCedula(@PathParam("cedulaEstudiante") String cedulaEstudiante) {
        return estudianteService.encontrarEstudiantesPorCedula(new Estudiantes(cedulaEstudiante));
    }

    @POST
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarEstudiantes(Estudiantes estudiante) {
        try {

            estudianteService.registrarEstudiantes(estudiante);
            return Response.ok().entity(estudiante).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}") //esto hace referencia a /estudiantes/{id}
    public Response modificarEstudiantes(@PathParam("id") int id,
            Estudiantes estudianteModificado) {

        try {
            Estudiantes estudiante = estudianteService
                    .encontrarEstudiantesPorId(new Estudiantes(id));

            if (estudiante != null) {
                estudianteService.modificarEstudiantes(estudianteModificado);
                return Response.ok().entity(estudianteModificado).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response eliminarEstudiantePorId(@PathParam("id") int id) {

        try {
            estudianteService.eliminarEstudiantes(new Estudiantes(id));
            return Response.ok().build();

        } catch (Exception e) {

            return Response.status(404).build();

        }
    }

}

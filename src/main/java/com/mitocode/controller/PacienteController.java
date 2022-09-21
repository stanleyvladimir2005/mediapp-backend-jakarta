package com.mitocode.controller;

import com.mitocode.model.Paciente;
import com.mitocode.repo.PacienteRepo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@RequestScoped
@Path("/pacientes")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class PacienteController {
    @Inject
    private PacienteRepo pacienteRepo;

    @GET
    public Response listar(){
         return Response.ok().entity(pacienteRepo.listar()).build();
    }

    @GET
    @Path("/{id}")
    public Paciente listarPorId(@PathParam("id") Integer id) {
        return pacienteRepo.listarPorId(new Paciente(id));
    }

    @POST
    public Response registrarPaciente(Paciente paciente, @Context UriInfo uriInfo){
       Paciente pac = pacienteRepo.registrar(paciente);
       UriBuilder builder = uriInfo.getAbsolutePathBuilder();
       builder.path(Integer.toString(pac.getIdPaciente()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    public Response modificarPaciente(Paciente paciente){
        pacienteRepo.actualizar(paciente);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminarPaciente(@PathParam("id") Integer id){
        Paciente pac = pacienteRepo.listarPorId(new Paciente(id));
        if (pac == null)
            throw new WebApplicationException("Paciente con el id" + id + " no existe.",404);

        pacienteRepo.eliminar(pac);
        return Response.noContent().build();
    }
}
package com.mitocode.controller;

import com.mitocode.model.Especialidad;
import com.mitocode.repo.EspecialidadRepo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@RequestScoped
@Path("/especialidades")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class EspecialidadController {
    @Inject
    private EspecialidadRepo especialidadRepo;

    @GET
    public Response listar(){
         return Response.ok().entity(especialidadRepo.listar()).build();
    }

    @GET
    @Path("/{id}")
    public Especialidad listarPorId(@PathParam("id") Integer id) {
        return especialidadRepo.listarPorId(new Especialidad(id));
    }

    @POST
    public Response registrarEspecialidad(Especialidad especialidad, @Context UriInfo uriInfo){
       Especialidad esp = especialidadRepo.registrar(especialidad);
       UriBuilder builder = uriInfo.getAbsolutePathBuilder();
       builder.path(Integer.toString(esp.getIdEspecialidad()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    public Response modificarEspecialidad(Especialidad especialidad){
        especialidadRepo.actualizar(especialidad);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminarEspecialidad(@PathParam("id") Integer id){
        Especialidad esp = especialidadRepo.listarPorId(new Especialidad(id));
        if (esp == null)
            throw new WebApplicationException("Especialidad con el id" + id + " no existe.",404);

        especialidadRepo.eliminar(esp);
        return Response.noContent().build();
    }
}
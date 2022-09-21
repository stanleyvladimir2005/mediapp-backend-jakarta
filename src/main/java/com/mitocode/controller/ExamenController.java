package com.mitocode.controller;

import com.mitocode.model.Examen;
import com.mitocode.repo.ExamenRepo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@RequestScoped
@Path("/examenes")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class ExamenController {
    @Inject
    private ExamenRepo examenRepo;

    @GET
    public Response listar(){
         return Response.ok().entity(examenRepo.listar()).build();
    }

    @GET
    @Path("/{id}")
    public Examen listarPorId(@PathParam("id") Integer id) {
        return examenRepo.listarPorId(new Examen(id));
    }

    @POST
    public Response registrarExamen(Examen examen, @Context UriInfo uriInfo){
       Examen ex = examenRepo.registrar(examen);
       UriBuilder builder = uriInfo.getAbsolutePathBuilder();
       builder.path(Integer.toString(ex.getIdExamen()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    public Response modificarExamen(Examen examen){
        examenRepo.actualizar(examen);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminarExamen(@PathParam("id") Integer id){
        Examen ex = examenRepo.listarPorId(new Examen(id));
        if (ex == null)
            throw new WebApplicationException("Examen con el id" + id + " no existe.",404);

        examenRepo.eliminar(ex);
        return Response.noContent().build();
    }
}
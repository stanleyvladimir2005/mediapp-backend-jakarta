package com.mitocode.controller;

import com.mitocode.model.Medico;
import com.mitocode.repo.MedicoRepo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@RequestScoped
@Path("/medicos")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class MedicoController {
    @Inject
    private MedicoRepo medicoRepo;

    @GET
    public Response listar(){
         return Response.ok().entity(medicoRepo.listar()).build();
    }

    @GET
    @Path("/{id}")
    public Medico listarPorId(@PathParam("id") Integer id) {
        return medicoRepo.listarPorId(new Medico(id));
    }

    @POST
    public Response registrarMedico(Medico medico, @Context UriInfo uriInfo){
       Medico med = medicoRepo.registrar(medico);
       UriBuilder builder = uriInfo.getAbsolutePathBuilder();
       builder.path(Integer.toString(med.getIdMedico()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    public Response modificarMedico(Medico medico){
        medicoRepo.actualizar(medico);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminarMedico(@PathParam("id") Integer id){
        Medico med = medicoRepo.listarPorId(new Medico(id));
        if (med == null)
            throw new WebApplicationException("Medico con el id" + id + " no existe.",404);

        medicoRepo.eliminar(med);
        return Response.noContent().build();
    }
}
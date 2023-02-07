package com.mitocode.controller;

import com.mitocode.model.Medic;
import com.mitocode.repo.MedicRepo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@RequestScoped
@Path("/medics")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class MedicController {
    @Inject
    private MedicRepo medicRepo;

    @GET
    public Response findAll(){
         return Response.ok().entity(medicRepo.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Medic findById(@PathParam("id") Integer id) {
        return medicRepo.findById(new Medic(id));
    }

    @POST
    public Response save(Medic medic, @Context UriInfo uriInfo){
       Medic med = medicRepo.save(medic);
       UriBuilder builder = uriInfo.getAbsolutePathBuilder();
       builder.path(Integer.toString(med.getIdMedic()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(Medic medic){
        medicRepo.update(medic);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id){
        Medic med = medicRepo.findById(new Medic(id));
        if (med == null)
            throw new WebApplicationException("ID NOT FOUND: "+id);
        medicRepo.delete(med);
        return Response.noContent().build();
    }
}
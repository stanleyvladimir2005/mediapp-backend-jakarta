package com.mitocode.controller;

import com.mitocode.model.Specialty;
import com.mitocode.repo.SpecialtyRepo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import lombok.val;

@RequestScoped
@Path("/specialtys")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class SpecialtyController {

    @Inject
    private SpecialtyRepo specialtyRepo;

    @GET
    public Response findAll(){
         return Response.ok().entity(specialtyRepo.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Specialty findById(@PathParam("id") Integer id) {
        return specialtyRepo.findById(new Specialty(id));
    }

    @POST
    public Response save(Specialty specialty, @Context UriInfo uriInfo){
       val specialtyBD = specialtyRepo.save(specialty);
       val builder = uriInfo.getAbsolutePathBuilder();
       builder.path(Integer.toString(specialtyBD.getIdSpecialty()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(Specialty specialty){
        specialtyRepo.update(specialty);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id){
        val specialty = specialtyRepo.findById(new Specialty(id));
        if (specialty == null)
            throw new WebApplicationException("ID NOT FOUND: "+id);
        specialtyRepo.delete(specialty);
        return Response.noContent().build();
    }
}
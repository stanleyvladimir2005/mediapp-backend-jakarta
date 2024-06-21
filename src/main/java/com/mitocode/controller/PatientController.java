package com.mitocode.controller;

import com.mitocode.model.Patient;
import com.mitocode.repo.PatientRepo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import lombok.val;

@RequestScoped
@Path("/patients")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class PatientController {

    @Inject
    private PatientRepo patientRepo;

    @GET
    public Response findAll(){
         return Response.ok().entity(patientRepo.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Patient findById(@PathParam("id") Integer id) {
        return patientRepo.findById(new Patient(id));
    }

    @POST
    public Response save(Patient patient, @Context UriInfo uriInfo){
       val patientDto = patientRepo.save(patient);
       val builder = uriInfo.getAbsolutePathBuilder();
       builder.path(Integer.toString(patientDto.getIdPatient()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(Patient patient){
        patientRepo.update(patient);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id){
        val patient = patientRepo.findById(new Patient(id));
        if (patient == null)
            throw new WebApplicationException("ID NOT FOUND: "+id);
        patientRepo.delete(patient);
        return Response.noContent().build();
    }
}
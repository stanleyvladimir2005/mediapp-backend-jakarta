package com.mitocode.controller;

import com.mitocode.model.Exam;
import com.mitocode.repo.ExamRepo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@RequestScoped
@Path("/exams")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class ExamController {
    @Inject
    private ExamRepo examRepo;

    @GET
    public Response findAll(){
         return Response.ok().entity(examRepo.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Exam findById(@PathParam("id") Integer id) {
        return examRepo.findById(new Exam(id));
    }

    @POST
    public Response save(Exam exam, @Context UriInfo uriInfo){
       Exam ex = examRepo.save(exam);
       UriBuilder builder = uriInfo.getAbsolutePathBuilder();
       builder.path(Integer.toString(ex.getIdExam()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(Exam exam){
        examRepo.update(exam);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminarExamen(@PathParam("id") Integer id){
        Exam ex = examRepo.findById(new Exam(id));
        if (ex == null)
            throw new WebApplicationException("ID NOT FOUND: "+id);
        examRepo.delete(ex);
        return Response.noContent().build();
    }
}
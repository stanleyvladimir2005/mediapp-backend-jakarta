package com.mitocode.controller;

import com.mitocode.model.Exam;
import com.mitocode.repo.ExamRepo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import lombok.val;

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
       val examDto = examRepo.save(exam);
       val builder = uriInfo.getAbsolutePathBuilder();
       builder.path(Integer.toString(examDto.getIdExam()));
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
        val exam = examRepo.findById(new Exam(id));
        if (exam == null)
            throw new WebApplicationException("ID NOT FOUND: "+id);
        examRepo.delete(exam);
        return Response.noContent().build();
    }
}
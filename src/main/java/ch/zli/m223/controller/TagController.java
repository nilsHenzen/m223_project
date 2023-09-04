package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
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

import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.zli.m223.model.Tags;
import ch.zli.m223.service.TagService;

@Path("/tags")
public class TagController {
    
    @Inject 
    TagService tagService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all tags.", description = "Returns a list of all tags.")
    public List<Tags> index() {
        return tagService.findAllTags();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new tag.", description = "Creates a new tag and returns it")
    public Tags create(Tags tags) {
        return tagService.createTag(tags);
    }

    @PUT
    @Path("/edit/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Update an Entry.", description = "Updates an existing entry.")
    public Response updateEntry(@PathParam("id") Long id, Tags updatedTag) {
        Tags existingTags = tagService.findById(id);

        if (existingTags == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        existingTags.setTagTitle(updatedTag.getTagTitle());

        tagService.update(existingTags);

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    @Operation(summary = "Delete an Entry.", description = "Deletes an entry by ID.")
    public Response deleteTag(@PathParam("id") Long id) {
        Tags tags = tagService.findById(id);

        if (tags == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        tagService.delete(tags);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

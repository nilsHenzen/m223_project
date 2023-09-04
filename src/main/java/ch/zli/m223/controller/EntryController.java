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
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Entry;
import ch.zli.m223.service.EntryService;

@Path("/entries")
@Tag(name = "Entries", description = "Handling of entries")
public class EntryController {

    @Inject
    EntryService entryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Entries.", description = "Returns a list of all entries.")
    public List<Entry> index() {
        return entryService.findAll();
    }

    @GET
    @Path("/tags")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Entries.", description = "Returns a list of all entries.")
    public List<Entry> getTags() {
        return entryService.findAll();
    }

    @GET
    @Path("/category")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Entries.", description = "Returns a list of all entries.")
    public List<Entry> getCategory() {
        return entryService.findAll();
    }



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new entry.", description = "Creates a new entry and returns the newly added entry.")
    public Entry create(Entry entry) {
       return entryService.createEntry(entry);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    @Operation(summary = "Delete an Entry.", description = "Deletes an entry by ID.")
    public Response deleteEntry(@PathParam("id") Long id) {
        Entry entry = entryService.findById(id);

        if (entry == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        entryService.delete(entry);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("/edit/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Update an Entry.", description = "Updates an existing entry.")
    public Response updateEntry(@PathParam("id") Long id, Entry updatedEntry) {
        Entry existingEntry = entryService.findById(id);

        if (existingEntry == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        existingEntry.setCheckIn(updatedEntry.getCheckIn());
        existingEntry.setCheckOut(updatedEntry.getCheckOut());

        entryService.update(existingEntry);

        return Response.status(Response.Status.OK).build();
    }

}

package ch.zli.m223.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.zli.m223.model.Role;
import ch.zli.m223.service.RoleService;

@Path("/role")
public class RoleController {

    @Inject
    RoleService roleService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Entries.", description = "Returns a list of all entries.")
    public List<Role> index() {
        return roleService.findAll();
    }
    
}

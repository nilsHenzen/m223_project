package ch.zli.m223.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.openapi.annotations.Operation;
import java.util.List;

import ch.zli.m223.model.Application_User;
import ch.zli.m223.service.UserService;

@Path("/users")
public class UserController {

    @Inject 
    UserService userService;

    @GET
    @Operation(summary = "Index all Entries.", description = "Returns a list of all entries.")
    public List<Application_User> getUsers() {
        return userService.findAll();
    }
    
}

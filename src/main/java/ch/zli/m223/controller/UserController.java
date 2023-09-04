package ch.zli.m223.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
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

    @POST
    @Path("/login")
    @Operation(summary = "loggs user in", description = "Returns JWT-Token after successful login")
    public Boolean login(@HeaderParam("Authorization") String authorizationHeader) {

        String[] parts = authorizationHeader.split(":", 2);
        String username = parts[0];
        String password = parts[1];

        Application_User userinfos = userService.login(username);


        String userpw = userinfos.getPassword();

        if (password.equals(userpw) ){
            return true;
        } else {
            return false;
        }

    }

    
}

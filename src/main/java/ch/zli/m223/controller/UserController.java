package ch.zli.m223.controller;

import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import java.util.List;

import ch.zli.m223.model.Application_User;
import ch.zli.m223.service.UserService;

@Path("/users")
public class UserController {

    @Inject 
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Entries.", description = "Returns a list of all entries.")
    public List<Application_User> getUsers() {
        return userService.findAll();
    }

    @POST
    @Path("/login")
    @Operation(summary = "loggs user in", description = "Returns JWT-Token after successful login")
    public Response login(@HeaderParam("Authorization") String authorizationHeader) {

        String[] parts = authorizationHeader.split(":", 2);
        String username = parts[0];
        String password = parts[1];

        Application_User userinfos = userService.login(username);


        String userpw = userinfos.getPassword();

        if (password.equals(userpw) ){
            return Response.status(200, "correct").build();
        } else {
            return Response.status(403, "wrong credentials").build();
        }

    }


    @GET
    @Path("/{id}")
    @Operation(summary = "get user by id", description = "Returns user that is searched by id")
    public Application_User getUserById(@PathParam("id") Long id) {

        return userService.getUserById(id);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "create new user", description = "Creates new User")
    public Response createUser(Application_User application_User) {

        return Response.status(201, "created").build();
    }


    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "updates user", description = "updates user")
    public Response updateUser(@PathParam("id") Long id, Application_User updatedUser) {
        Application_User existingUser = userService.getUserById(id);

        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setEmail(updatedUser.getFirstName());
        existingUser.setLastnameName(updatedUser.getLastName());

        userService.updateUser(existingUser);

        return Response.status(201, "updated").build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Operation(summary = "delete user", description = "delete user by id")
    public Response deleteUser(@PathParam("id") Long id) {
        Application_User existingUser = userService.getUserById(id);

        userService.deleteUser(existingUser);

        return Response.status(200, "deleted").build();
    }

    
}

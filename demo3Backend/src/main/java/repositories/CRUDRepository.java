package repositories;

import Beans.CRUDBean;
import entity.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;


@Path("users")
public class CRUDRepository {

    @Inject
    CRUDBean CRUD;



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
        try {
            List<User> users = CRUD.FindAll();
//            GenericEntity<List<User>> listUsers = new GenericEntity<List<User>>(users){};
            return Response.ok(users.toArray()).build();
        }catch (Exception e){
            return Response.ok(false).build();
        }

    };

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public  Response getUserById(@PathParam("id") Long id){
//        User user = new User();
//        user.setName("Omar");
//        user.setDetails("junior software engineer");
          try{
              User user =  CRUD.FindById(id);
              System.out.println("done");
              return Response.ok(user).build();
           }catch (Exception e){
             return Response.ok(false).build();
           }

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("update")
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    @Produces(MediaType.APPLICATION_JSON)
    public Response update(User user){
//        CompletionStage<User> UserObject = (CompletionStage<User>) CRUD.FindByName(name);
//        UserObject.thenApply(user -> CRUD.UpdateUser(user));
        try {
//            User user = new User();
//            user.setId(1L);
//            user.setName("Omar");
//            user.setDetails("senior software engineer");
            User user1=CRUD.UpdateUser(user);
//            User oneUser = CRUD.FindByName(user.getName());

//            User oneUser = CompletableFuture.supplyAsync(()->CRUD.FindByName("Omar")).join();
//            CRUD.UpdateUser(oneUser);
            return Response.ok(user1).build();
        } catch (Exception e){
            return Response.ok(false).build();
        }

    }

    @POST
    @Path("oneuser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user){
//        User user = new User();
//        user.setName(name);
//        user.setDetails(details);
        try {
            CRUD.createUser(user);
            return Response.ok(user).build();
        }catch (Exception e){
            return Response.ok(false).build();
        }
    };
}

package RESTservices;

import hibernateEntities.User;
import hibernateManagers.CharityLoginManager;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/charityLogin")
public class CharityLogin {


@GET
@Path("/CharityDB/{DBConfigPath}/userName/{username}")
@Produces("application/json")
public User getUsersFromName(@PathParam("DBConfigPath")String DBConfigPath,@PathParam("username")String username){

System.out.println("Get Request recieved");
ArrayList<User> holder = CharityLoginManager.getUsers(username, DBConfigPath);
System.out.println("User array list populated");

return holder.get(0);
}

}
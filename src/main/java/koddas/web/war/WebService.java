package koddas.web.war;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

/**
 * A very simple web service.
 * 
 * @author Johan Holmberg
 */
public class WebService {
	
	@GET
	@Path("/hello")
	@Produces("text/plain")
	public Response hello() {
		return Response.ok("Hello, World!").build();
	}

	@GET
	@Path("/time")
	@Produces("application/json")
	public Response time() {
		Gson gson = new Gson();
		Response response = null;
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		
		gson.toJson(df.format(dateobj));
		response = Response.ok(gson.toString()).build();
		
		return response;
	}
	
	@POST
	@Path("/send")
	@Produces("application/json")
	public Response send(@FormParam("name") String name,
			@FormParam("age") int age,
			@FormParam("nationality") String nationality,
			@FormParam("car_brand") String carBrand) {
		Gson gson = new Gson();
		MrBean bean = new MrBean();
		
		bean.setName(name);
		bean.setAge(age);
		bean.setNationality(nationality);
		bean.setCarBrand(carBrand);
		
		gson.toJson(bean);
		
		return Response.ok(gson).build();
	}
	
	@POST
	@Path("/send/{to}")
	@Produces("application/json")
	public Response send(@PathParam("to") String to,
			@FormParam("name") String name,
			@FormParam("age") int age,
			@FormParam("nationality") String nationality,
			@FormParam("carBrand") String carBrand) {
		Gson gson = new Gson();
		MrBean bean = new MrBean();
		Map<String, Object> map = new HashMap<String, Object>();
		
		bean.setName(name);
		bean.setAge(age);
		bean.setNationality(nationality);
		bean.setCarBrand(carBrand);
		
		map.put("to", to);
		map.put("mr_bean", bean);
		
		gson.toJson(map);
		
		return Response.ok(gson).build();
	}
}

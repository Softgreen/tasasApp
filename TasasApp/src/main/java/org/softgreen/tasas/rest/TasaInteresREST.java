package org.softgreen.tasas.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.softgreen.tasas.model.TasaInteres;

@Path("/tasasInteres")
public interface TasaInteresREST {

	@GET
	@Produces({ "application/json" })
	public Response findAll();

	@GET
	@Path("/{naturalId}")
	@Produces({ "application/json" })
	public Response findByDenominacion(
			@PathParam("naturalId") String abreviatura);

	@POST
	@Produces({ "application/json" })
	public Response create(TasaInteres servicio);

	@PUT
	@Path("/{naturalId}")
	@Produces({ "application/json" })
	public Response update(@PathParam("naturalId") String abreviatura,
			TasaInteres tasaInteres);

	@DELETE
	@Path("/{naturalId}")
	@Produces({ "application/json" })
	public Response delete(@PathParam("naturalId") String abreviatura);

}

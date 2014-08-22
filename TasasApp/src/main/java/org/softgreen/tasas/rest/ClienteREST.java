package org.softgreen.tasas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/tasas")
public interface ClienteREST {

	@GET
	@Path("/{denominacionTasaInteres}")
	@Produces({ "application/json" })
	public Response findByDenominacion(
			@PathParam("denominacionTasaInteres") String denominacionTasaInteres);

}

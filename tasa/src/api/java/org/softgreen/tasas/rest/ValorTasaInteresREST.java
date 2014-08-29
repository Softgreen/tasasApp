package org.softgreen.tasas.rest;

import java.math.BigDecimal;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.softgreen.tasas.model.ValorTasaInteres;

@Path("/valorTasasInteres")
public interface ValorTasaInteresREST {

	@GET
	@Produces({ "application/json" })
	public Response findAll(@QueryParam("servico") String servicio,
			@QueryParam("moneda") String moneda,
			@QueryParam("montoMinimo") BigDecimal montoMinimo,
			@QueryParam("montoMaximo") BigDecimal montoMaximo,
			@QueryParam("periodoMinimo") Integer periodoMinimo,
			@QueryParam("periodoMaximo") Integer periodoMaximo,
			@QueryParam("fechaInicio") Long fechaInicio,
			@QueryParam("fechaFin") Long fechaFin,
			@QueryParam("estado") Boolean estado);

	@GET
	@Path("/{id}")
	@Produces({ "application/json" })
	public Response findByDenominacion(@PathParam("id") Long id);

	@POST
	@Produces({ "application/json" })
	public Response create(ValorTasaInteres valorTasaInteres);

	@PUT
	@Path("/{id}")
	@Produces({ "application/json" })
	public Response update(@PathParam("id") Long id,
			ValorTasaInteres valorTasaInteres);

	@DELETE
	@Path("/{id}")
	@Produces({ "application/json" })
	public Response delete(@PathParam("id") Long id);

}

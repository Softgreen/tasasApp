package org.softgreen.moneda.boundary;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.softgreen.moneda.controller.TasaCambioController;
import org.softgreen.moneda.entity.Moneda;

@Path("/tasasCambio")
public class TasaCambioREST {

	@Inject
	private TasaCambioController tasaCambioController;

	@GET
	public Response getTasaCambio(@QueryParam("codigoOrigen") String codigoOrigen, @QueryParam("codigoDestino") String codigoDestino) {
		Response response;

		Moneda monedaOrigen = new Moneda(codigoOrigen);
		Moneda monedaDestino = new Moneda(codigoDestino);
		BigDecimal tasa = tasaCambioController.getTasaCambio(monedaOrigen, monedaDestino);

		response = Response.status(Status.OK).entity(tasa).build();

		return response;
	}
}

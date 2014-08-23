package org.softgreen.tasas.rest.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.softgreen.exception.NonexistentEntityException;
import org.softgreen.exception.PreexistingEntityException;
import org.softgreen.exception.RollbackFailureException;
import org.softgreen.tasas.model.Servicio;
import org.softgreen.tasas.rest.ServicioREST;
import org.softgreen.tasas.service.ServicioService;

public class ServicioRESTService implements ServicioREST {

	@EJB
	private ServicioService servicioService;

	@Override
	public Response findAll() {
		List<Servicio> list = servicioService.findAll();
		Response response = Response.status(Status.OK).entity(list).build();
		return response;
	}

	@Override
	public Response findByDenominacion(String denominacion) {
		Servicio servicio = servicioService.findById(denominacion);
		Response response = Response.status(Status.OK).entity(servicio).build();
		return response;
	}

	@Override
	public Response create(Servicio servicio) {
		Response response = null;
		try {
			servicioService.create(servicio);
			response = Response.status(Status.CREATED).build();
		} catch (PreexistingEntityException e) {
			response = Response.status(Status.CONFLICT).build();
		} catch (RollbackFailureException e) {
			response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}

	@Override
	public Response update(String denominacion, Servicio servicio) {
		Response response = null;
		try {
			servicioService.update(denominacion, servicio);
			response = Response.status(Status.NO_CONTENT).build();
		} catch (NonexistentEntityException e) {
			response = Response.status(Status.NOT_FOUND).build();
		} catch (PreexistingEntityException e) {
			response = Response.status(Status.CONFLICT).build();
		} catch (RollbackFailureException e) {
			response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}

	@Override
	public Response delete(String denominacion) {
		Response response = null;
		try {
			servicioService.delete(denominacion);
			response = Response.status(Status.NO_CONTENT).build();
		} catch (NonexistentEntityException e) {
			response = Response.status(Status.NOT_FOUND).build();
		} catch (RollbackFailureException e) {
			response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}
}

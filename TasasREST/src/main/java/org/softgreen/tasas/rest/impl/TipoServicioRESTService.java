package org.softgreen.tasas.rest.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.softgreen.exception.NonexistentEntityException;
import org.softgreen.exception.PreexistingEntityException;
import org.softgreen.exception.RollbackFailureException;
import org.softgreen.tasas.model.TipoServicio;
import org.softgreen.tasas.rest.Jsend;
import org.softgreen.tasas.rest.TipoServicioREST;
import org.softgreen.tasas.service.TipoServicioService;

public class TipoServicioRESTService implements TipoServicioREST {

	@EJB
	private TipoServicioService tipoServicioService;
	
	@Override
	public Response findAll() {
		List<TipoServicio> list = tipoServicioService.findAll();
		Jsend jsend = Jsend.getSuccessJSend();
		jsend.setData(list);
		Response response = Response.status(Status.OK).entity(jsend).build();
		return response;
	}

	@Override
	public Response findByDenominacion(String denominacion) {
		TipoServicio tipoServicio = tipoServicioService.findById(denominacion);
		Response response = Response.status(Status.OK).entity(tipoServicio).build();
		return response;
	}

	@Override
	public Response create(TipoServicio tipoServicio) {
		Response response = null;
		try {
			tipoServicioService.create(tipoServicio);
			response = Response.status(Status.CREATED).build();
		} catch (PreexistingEntityException e) {
			response = Response.status(Status.CONFLICT).build();
		} catch (RollbackFailureException e) {
			response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}

	@Override
	public Response update(String denominacion, TipoServicio tipoServicio) {
		Response response = null;
		try {
			tipoServicioService.update(denominacion, tipoServicio);
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
			tipoServicioService.delete(denominacion);
			response = Response.status(Status.NO_CONTENT).build();
		} catch (NonexistentEntityException e) {
			response = Response.status(Status.NOT_FOUND).build();
		} catch (RollbackFailureException e) {
			response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}
	
}

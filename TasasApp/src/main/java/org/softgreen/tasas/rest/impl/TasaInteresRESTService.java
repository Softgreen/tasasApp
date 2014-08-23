package org.softgreen.tasas.rest.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.softgreen.exception.NonexistentEntityException;
import org.softgreen.exception.PreexistingEntityException;
import org.softgreen.exception.RollbackFailureException;
import org.softgreen.tasas.model.TasaInteres;
import org.softgreen.tasas.rest.TasaInteresREST;
import org.softgreen.tasas.service.TasaInteresService;

public class TasaInteresRESTService implements TasaInteresREST {

	@EJB
	private TasaInteresService tasaInteresService;

	@Override
	public Response findAll() {
		List<TasaInteres> list = tasaInteresService.findAll();
		Response response = Response.status(Status.OK).entity(list).build();
		return response;
	}

	@Override
	public Response findByDenominacion(String abreviatura) {
		TasaInteres tasaInteres = tasaInteresService.findById(abreviatura);
		Response response = Response.status(Status.OK).entity(tasaInteres)
				.build();
		return response;
	}

	@Override
	public Response create(TasaInteres tasaInteres) {
		Response response = null;
		try {
			tasaInteresService.create(tasaInteres);
			response = Response.status(Status.CREATED).build();
		} catch (PreexistingEntityException e) {
			response = Response.status(Status.CONFLICT).build();
		} catch (RollbackFailureException e) {
			response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}

	@Override
	public Response update(String abreviatura, TasaInteres tasaInteres) {
		Response response = null;
		try {
			tasaInteresService.update(abreviatura, tasaInteres);
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
	public Response delete(String abreviatura) {
		Response response = null;
		try {
			tasaInteresService.delete(abreviatura);
			response = Response.status(Status.NO_CONTENT).build();
		} catch (NonexistentEntityException e) {
			response = Response.status(Status.NOT_FOUND).build();
		} catch (RollbackFailureException e) {
			response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}

}

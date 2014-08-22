package org.softgreen.tasas.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.softgreen.dao.DAO;
import org.softgreen.dao.QueryParameter;
import org.softgreen.exception.NonexistentEntityException;
import org.softgreen.exception.PreexistingEntityException;
import org.softgreen.exception.RollbackFailureException;
import org.softgreen.tasas.model.Servicio;
import org.softgreen.tasas.model.TipoServicio;
import org.softgreen.tasas.service.TipoServicioService;

@Named
@Stateless
@Remote(TipoServicioService.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class TipoServicioServiceBean implements TipoServicioService {

	@Inject
	private DAO<Integer, TipoServicio> tipoServicioDAO;

	@Inject
	private Validator validator;

	@Override
	public TipoServicio findById(Integer id) {
		return tipoServicioDAO.find(id);
	}

	@Override
	public List<TipoServicio> findAll() {
		return tipoServicioDAO.findAll();
	}

	@Override
	public Integer create(TipoServicio t) throws PreexistingEntityException,RollbackFailureException {
		Set<ConstraintViolation<TipoServicio>> violations = validator.validate(t);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
		}
		String denominacion = t.getDenominacion();
		QueryParameter queryParameter = QueryParameter.with("denominacion", denominacion);
		List<TipoServicio> list = tipoServicioDAO.findByNamedQuery(TipoServicio.findByDenominacion, queryParameter.parameters());
		if (list.size() != 0) {
			tipoServicioDAO.create(t);
			return t.getIdTipoServicio();
		} else {
			throw new PreexistingEntityException("Tipo servicio ya existente");
		}
	}

	@Override
	public void update(Integer id, TipoServicio t)throws NonexistentEntityException, PreexistingEntityException,RollbackFailureException {
		Set<ConstraintViolation<TipoServicio>> violations = validator.validate(t);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
		}
		TipoServicio tipoServicio = tipoServicioDAO.find(id);
		if (tipoServicio != null) {			
			String denominacion = t.getDenominacion();
			QueryParameter queryParameter = QueryParameter.with("denominacion",denominacion);
			List<TipoServicio> list = tipoServicioDAO.findByNamedQuery(TipoServicio.findByDenominacion,queryParameter.parameters());
			if (list.size() != 0 && id.equals(tipoServicio.getIdTipoServicio())) {
				tipoServicioDAO.update(t);				
			} else {
				throw new PreexistingEntityException("Tipo de servicio ya existente");
			}
		} else {
			throw new NonexistentEntityException("Tipo servicio no encontrado");
		}
	}

	@Override
	public void delete(Integer id) throws NonexistentEntityException, RollbackFailureException {
		TipoServicio tipoServicio = tipoServicioDAO.find(id);
		if(tipoServicio != null) { 
			Set<Servicio> servicios = tipoServicio.getServicios();
			if(servicios.size() == 0) { 
				tipoServicioDAO.delete(tipoServicio);
			} else {
				throw new RollbackFailureException("Tipo de servicios contiene servicios activos, no se puede eliminar");
			}
		} else {
			throw new NonexistentEntityException("Tipo de servicio no encontrado");
		}
	}

}

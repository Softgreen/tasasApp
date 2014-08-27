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
import org.softgreen.exception.NonexistentEntityException;
import org.softgreen.exception.PreexistingEntityException;
import org.softgreen.exception.RollbackFailureException;
import org.softgreen.tasas.model.Servicio;
import org.softgreen.tasas.model.ValorTasaInteres;
import org.softgreen.tasas.service.ServicioService;

@Named
@Stateless
@Remote(ServicioService.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ServicioServiceBean implements ServicioService {

	@Inject
	private DAO<String, Servicio> servicioDAO;

	@Inject
	private Validator validator;

	@Override
	public Servicio findById(String id) {
		return servicioDAO.find(id);
	}

	@Override
	public List<Servicio> findAll() {
		return servicioDAO.findAll();
	}

	@Override
	public String create(Servicio t) throws PreexistingEntityException,RollbackFailureException {
		Set<ConstraintViolation<Servicio>> violations = validator.validate(t);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
		}
		
		String denominacion = t.getDenominacion();
		Servicio servicio = servicioDAO.find(denominacion);
		if (servicio == null) {
			servicioDAO.create(t);
			return t.getDenominacion();
		} else {
			throw new PreexistingEntityException("Servicio ya existente");
		}
	}

	@Override
	public void update(String id, Servicio t)throws NonexistentEntityException, PreexistingEntityException,RollbackFailureException {
		Set<ConstraintViolation<Servicio>> violations = validator.validate(t);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
		}
		Servicio servicio = servicioDAO.find(id);
		if (servicio != null) {			
			if (servicio.equals(t)) {
				servicioDAO.update(t);				
			} else {
				throw new PreexistingEntityException("Servicio ya existente");
			}
		} else {
			throw new NonexistentEntityException("Servicio no encontrado");
		}
	}

	@Override
	public void delete(String id) throws NonexistentEntityException, RollbackFailureException {
		Servicio Servicio = servicioDAO.find(id);
		if(Servicio != null) { 
			Set<ValorTasaInteres> valoresTasasInteres = Servicio.getValorTasaIntereses();
			if(valoresTasasInteres.size() == 0) { 
				servicioDAO.delete(Servicio);
			} else {
				throw new RollbackFailureException("Tipo de servicios contiene servicios activos, no se puede eliminar");
			}
		} else {
			throw new NonexistentEntityException("Tipo de servicio no encontrado");
		}
	}

}

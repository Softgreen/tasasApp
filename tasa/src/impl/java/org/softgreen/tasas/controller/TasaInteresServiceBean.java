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
import org.softgreen.tasas.model.TasaInteres;
import org.softgreen.tasas.model.ValorTasaInteres;
import org.softgreen.tasas.service.TasaInteresService;

@Named
@Stateless
@Remote(TasaInteresService.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class TasaInteresServiceBean implements TasaInteresService {

	@Inject
	private DAO<String, TasaInteres> tasaInteresDAO;

	@Inject
	private Validator validator;

	@Override
	public TasaInteres findById(String id) {
		return tasaInteresDAO.find(id);
	}

	@Override
	public List<TasaInteres> findAll() {
		return tasaInteresDAO.findAll();
	}

	@Override
	public String create(TasaInteres t) throws PreexistingEntityException,RollbackFailureException {
		Set<ConstraintViolation<TasaInteres>> violations = validator.validate(t);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
		}
		
		String abreviatura = t.getAbreviatura();
		TasaInteres tasaInteres = tasaInteresDAO.find(abreviatura);
		if (tasaInteres == null) {
			tasaInteresDAO.create(t);
			return t.getAbreviatura();
		} else {
			throw new PreexistingEntityException("Tasa de interes ya existente");
		}
	}

	@Override
	public void update(String id, TasaInteres t)throws NonexistentEntityException, PreexistingEntityException,RollbackFailureException {
		Set<ConstraintViolation<TasaInteres>> violations = validator.validate(t);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
		}
		TasaInteres tasaInteres = tasaInteresDAO.find(id);
		if (tasaInteres != null) {			
			if (tasaInteres.equals(t)) {
				tasaInteresDAO.update(t);				
			} else {
				throw new PreexistingEntityException("Tasa de interes ya existente");
			}
		} else {
			throw new NonexistentEntityException("Tasa de interes no encontrado");
		}
	}

	@Override
	public void delete(String id) throws NonexistentEntityException, RollbackFailureException {
		TasaInteres tasaInteres = tasaInteresDAO.find(id);
		if(tasaInteres != null) { 
			Set<ValorTasaInteres> valoresTasasInteres = tasaInteres.getValorTasaIntereses();
			if(valoresTasasInteres.size() == 0) { 
				tasaInteresDAO.delete(tasaInteres);
			} else {
				throw new RollbackFailureException("Tasa Interess contiene TasaInteress activos, no se puede eliminar");
			}
		} else {
			throw new NonexistentEntityException("Tasa Interes no encontrado");
		}
	}

}

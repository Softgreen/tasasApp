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
import org.softgreen.tasas.model.ValorTasaInteres;
import org.softgreen.tasas.service.ValorTasaInteresService;

@Named
@Stateless
@Remote(ValorTasaInteresService.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ValorTasaInteresServiceBean implements ValorTasaInteresService {

	@Inject
	private DAO<Long, ValorTasaInteres> valorTasaInteresDAO;

	@Inject
	private Validator validator;

	@Override
	public ValorTasaInteres findById(Long id) {
		return valorTasaInteresDAO.find(id);
	}

	@Override
	public List<ValorTasaInteres> findAll() {
		return valorTasaInteresDAO.findAll();
	}

	@Override
	public Long create(ValorTasaInteres t) throws PreexistingEntityException,RollbackFailureException {
		Set<ConstraintViolation<ValorTasaInteres>> violations = validator.validate(t);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
		}		
		valorTasaInteresDAO.create(t);
		return t.getIdValorTasaInteres();
	}

	@Override
	public void update(Long id, ValorTasaInteres t)throws NonexistentEntityException, PreexistingEntityException,RollbackFailureException {
		Set<ConstraintViolation<ValorTasaInteres>> violations = validator.validate(t);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
		}
		ValorTasaInteres servicio = valorTasaInteresDAO.find(id);
		if (servicio != null) {			
			if (servicio.equals(t)) {
				valorTasaInteresDAO.update(t);				
			} else {
				throw new PreexistingEntityException("ValorTasaInteres ya existente");
			}
		} else {
			throw new NonexistentEntityException("ValorTasaInteres no encontrado");
		}
	}

	@Override
	public void delete(Long id) throws NonexistentEntityException, RollbackFailureException {
		ValorTasaInteres valorTasaInteres = valorTasaInteresDAO.find(id);
		if(valorTasaInteres != null) { 
			valorTasaInteresDAO.delete(valorTasaInteres);
		} else {
			throw new NonexistentEntityException("Tipo de servicio no encontrado");
		}
	}

}

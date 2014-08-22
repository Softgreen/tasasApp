package org.softgreen.tasas.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.inject.Named;

import org.softgreen.dao.DAO;
import org.softgreen.exception.NonexistentEntityException;
import org.softgreen.exception.PreexistingEntityException;
import org.softgreen.exception.RollbackFailureException;
import org.softgreen.tasas.model.Servicio;
import org.softgreen.tasas.service.ServicioService;

@Named
@Stateless
@Remote(ServicioService.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ServicioServiceBean implements ServicioService {

	@Inject
	private DAO<Integer, Servicio> servicioDAO;

	@Override
	public Servicio findById(Integer id) {
		return servicioDAO.find(id);
	}

	@Override
	public List<Servicio> findAll() {
		return servicioDAO.findAll();
	}

	@Override
	public Integer create(Servicio t) throws PreexistingEntityException,
			RollbackFailureException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Integer id, Servicio t)
			throws NonexistentEntityException, PreexistingEntityException,
			RollbackFailureException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) throws NonexistentEntityException,
			RollbackFailureException {
		// TODO Auto-generated method stub

	}

}

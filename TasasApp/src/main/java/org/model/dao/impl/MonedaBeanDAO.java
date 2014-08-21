/**
This file is part of javaee-patterns.

javaee-patterns is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

javaee-patterns is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.opensource.org/licenses/gpl-2.0.php>.

 * Copyright (c) 22. June 2009 Adam Bien, blog.adam-bien.com
 * http://press.adam-bien.com
 */
package org.model.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.model.Moneda;
import org.model.dao.DAOFactory;

/**
 * A minimalistic CRUD implementation. Usually provides the implementation of
 * search methods as well.
 * 
 * @author adam-bien.com
 */
@Stateless
@Local(DAOFactory.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class MonedaBeanDAO implements DAOFactory<Object, Moneda> {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Moneda find(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Moneda> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Moneda create(Moneda t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Moneda update(Moneda t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Moneda t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Moneda> findByNamedQuery(String queryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Moneda> findByNamedQuery(String queryName, int resultLimit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Moneda> findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Moneda> findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters, int resultLimit) {
		// TODO Auto-generated method stub
		return null;
	}

}

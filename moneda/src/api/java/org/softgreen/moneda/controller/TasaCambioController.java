package org.softgreen.moneda.controller;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.softgreen.moneda.entity.Moneda;

@Stateless
public class TasaCambioController {

	@PersistenceContext
	EntityManager em;

	public BigDecimal getTasaCambio(Moneda origen, Moneda destino) {
		return null;
	}

}

package org.softgreen.ubigeo.controller;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TasaCambioController {

	@PersistenceContext
	EntityManager em;

	public BigDecimal getTasaCambio(String monedaOrigen, String monedaDestino) {
		return null;
	}

}

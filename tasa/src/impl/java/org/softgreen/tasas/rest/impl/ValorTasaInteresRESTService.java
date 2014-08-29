package org.softgreen.tasas.rest.impl;

import java.math.BigDecimal;

import javax.ws.rs.core.Response;

import org.softgreen.tasas.model.ValorTasaInteres;
import org.softgreen.tasas.rest.ValorTasaInteresREST;

public class ValorTasaInteresRESTService implements ValorTasaInteresREST {

	@Override
	public Response findAll(String servicio, String moneda,
			BigDecimal montoMinimo, BigDecimal montoMaximo,
			Integer periodoMinimo, Integer periodoMaximo, Long fechaInicio,
			Long fechaFin, Boolean estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response findByDenominacion(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response create(ValorTasaInteres valorTasaInteres) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response update(Long id, ValorTasaInteres valorTasaInteres) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

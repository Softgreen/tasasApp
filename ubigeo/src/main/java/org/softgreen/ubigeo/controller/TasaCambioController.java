package org.softgreen.ubigeo.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.softgreen.dao.DAO;
import org.softgreen.dao.QueryParameter;
import org.softgreen.ubigeo.entity.Moneda;
import org.softgreen.ubigeo.entity.TasaCambio;

@Stateless
public class TasaCambioController {

	@Inject
	private DAO<String, Moneda> monedaDAO;

	@Inject
	private DAO<Long, TasaCambio> tasaCambioDAO;

	public BigDecimal getTasaCambio(String codigoMonedaOrigen, String codigoMonedaDestino) {
		Moneda monedaOrigen = monedaDAO.find(codigoMonedaOrigen);
		Moneda monedaDestino = monedaDAO.find(codigoMonedaDestino);
		if (monedaOrigen == null)
			return null;
		if (monedaDestino == null)
			return null;

		Calendar calendar = Calendar.getInstance();
		Date fecha = calendar.getTime();

		QueryParameter queryParameter = QueryParameter.with("codigoMonedaOrigen", codigoMonedaOrigen).and("codigoMonedaDestino", codigoMonedaDestino).and("fecha", fecha);
		List<TasaCambio> list = tasaCambioDAO.findByNamedQuery(TasaCambio.findByMonedaOrigenDestino, queryParameter.parameters());

		if (list.size() <= 1) {
			BigDecimal result = null;
			for (TasaCambio tasaCambio : list) {
				result = tasaCambio.getValor();
			}
			return result;
		} else {
			System.out.println("Error en base de datos");
			return null;
		}
	}

	public BigDecimal getTasaCambio(String codigoMonedaOrigen, String codigoMonedaDestino, Date fecha) {
		Moneda monedaOrigen = monedaDAO.find(codigoMonedaOrigen);
		Moneda monedaDestino = monedaDAO.find(codigoMonedaDestino);
		if (monedaOrigen == null)
			return null;
		if (monedaDestino == null)
			return null;
		if (fecha == null)
			return null;

		QueryParameter queryParameter = QueryParameter.with("codigoMonedaOrigen", codigoMonedaOrigen).and("codigoMonedaDestino", codigoMonedaDestino).and("fecha", fecha);
		List<TasaCambio> list = tasaCambioDAO.findByNamedQuery(TasaCambio.findByMonedaOrigenDestino, queryParameter.parameters());

		if (list.size() <= 1) {
			BigDecimal result = null;
			for (TasaCambio tasaCambio : list) {
				result = tasaCambio.getValor();
			}
			return result;
		} else {
			System.out.println("Error en base de datos");
			return null;
		}
	}

}

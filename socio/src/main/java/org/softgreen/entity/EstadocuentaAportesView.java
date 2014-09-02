package org.softgreen.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

/**
 * The persistent class for the ESTADOCUENTA_APORTES_VIEW database table.
 * 
 */

public class EstadocuentaAportesView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String numeroCuentaAporte;
	private BigDecimal saldo;
	private BigDecimal idTransaccion;
	private BigInteger numeroOperacion;
	private String tipoTransaccion;
	private Date fecha;
	private Date hora;
	private BigDecimal monto;
	private BigDecimal saldoDisponible;
	private String referencia;
	private int estado;

	public EstadocuentaAportesView() {
	}

}
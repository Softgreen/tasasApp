package org.sistemafinanciero.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * The persistent class for the ESTADOCUENTA_BANCARIA_VIEW database table.
 * 
 */
public class EstadocuentaBancariaView implements Serializable {

	private static final long serialVersionUID = 1L;

	public final static String findByNumeroCuentaAndDesdeHasta = "EstadocuentaBancariaView.findByNumeroCuentaAndDesdeHasta";

	private String numeroCuenta;

	private BigDecimal saldo;

	private BigDecimal idTransaccionTransferencia;

	private BigInteger numeroOperacion;

	private String tipoTransaccionTransferencia;

	private Date fecha;

	private Date hora;

	private BigDecimal monto;

	private BigDecimal saldoDisponible;

	private String referencia;

	private int estado;

	public EstadocuentaBancariaView() {
	}

}
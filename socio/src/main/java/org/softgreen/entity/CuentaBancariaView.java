package org.softgreen.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * The persistent class for the CUENTA_BANCARIA_VIEW database table.
 * 
 */
public class CuentaBancariaView implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public final static String FindByFilterTextCuentaBancariaView = "CuentaBancariaView.FindByFilterTextCuentaBancariaView";
	public final static String findByNumeroCuenta = "CuentaBancariaView.findByNumeroCuenta";
	public final static String findByIdSocio = "CuentaBancariaView.findByIdSocio";

	private BigInteger idCuentaBancaria;
	private TipoCuentaBancaria tipoCuenta;
	private String numeroCuenta;	
	private EstadoCuentaBancaria estadoCuenta;
	private BigInteger idMoneda;
	private String moneda;
	private BigDecimal tasaInteres;
	private BigDecimal saldo;
	private int cantidadRetirantes;
	private Date fechaApertura;
	private Date fechaCierre;
	
	private BigInteger idSocio;
	private String socio;
	
	private TipoPersona tipoPersona;
	private BigInteger idTipoDocumento;
	private String tipoDocumento;
	private String numeroDocumento;
	
	public CuentaBancariaView() {
	}

	
}
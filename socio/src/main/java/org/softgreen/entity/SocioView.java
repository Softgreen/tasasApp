package org.softgreen.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * The persistent class for the SOCIO_VIEW database table.
 * 
 */
public class SocioView implements Serializable {
	private static final long serialVersionUID = 1L;

	public final static String findAll = "SocioView.findAll";
	public final static String FindAllHaveCuentaAporte = "SocioView.FindAllHaveCuentaAporte";
	public final static String FindByFilterTextSocioView = "SocioView.FindByFilterTextSocioView";
	public final static String FindByFilterTextSocioViewAllHaveCuentaAporte = "SocioView.FindByFilterTextSocioViewAllHaveCuentaAporte";
	public final static String FindByTipoAndNumeroDocumento = "SocioView.FindByTipoAndNumeroDocumento";

	private BigInteger idsocio;
	private int estadoSocio;
	private Date fechaAsociado;
	private Date fechaFin;

	private BigInteger idCuentaAporte;
	private String numeroCuentaAporte;
	private EstadoCuentaAporte estadoCuentaAporte;

	private TipoPersona tipoPersona;
	private BigInteger idTipoDocumento;
	private String tipoDocumento;
	private String numeroDocumento;
	private String socio;
	private Date fechaNacimiento;

	private BigInteger idApoderado;
	private String codigoAgencia;

	public SocioView() {
	}

}
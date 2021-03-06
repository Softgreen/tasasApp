package org.softgreen.organizacion.entity;

// Generated 02-may-2014 11:48:28 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TransaccionBovedaCaja generated by hbm2java
 */

@Table
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class TransaccionBovedaBoveda extends TransaccionInterna implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private HistorialBoveda historialBoveda;
	private HistorialCaja historialCaja;

	private BigDecimal saldoDisponibleOrigen;
	private BigDecimal saldoDisponibleDestino;
	
	private boolean estadoSolicitud;
	private boolean estadoConfirmacion;
	
	private String origen;
	
	private Set detalle = new HashSet(0);

	public TransaccionBovedaBoveda() {
	}

}

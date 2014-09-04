package org.softgreen.organizacion.model;

// Generated 02-may-2014 11:48:28 by Hibernate Tools 4.0.0

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * TransaccionBovedaCaja generated by hbm2java
 */

@Entity
@Table(indexes = { @Index(columnList = "id") })
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class TransaccionBovedaCaja extends TransaccionInterna implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private HistorialBoveda historialBoveda;
	private HistorialCaja historialCaja;

	private BigDecimal saldoDisponibleOrigen;
	private BigDecimal saldoDisponibleDestino;

	private String origen;

	public TransaccionBovedaCaja() {
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey)
	public HistorialBoveda getHistorialBoveda() {
		return historialBoveda;
	}

	public void setHistorialBoveda(HistorialBoveda historialBoveda) {
		this.historialBoveda = historialBoveda;
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey)
	public HistorialCaja getHistorialCaja() {
		return historialCaja;
	}

	public void setHistorialCaja(HistorialCaja historialCaja) {
		this.historialCaja = historialCaja;
	}

	@NotNull
	@Min(value = 0)
	@DecimalMin(value = "0")
	@Digits(integer = 18, fraction = 2)
	public BigDecimal getSaldoDisponibleOrigen() {
		return saldoDisponibleOrigen;
	}

	public void setSaldoDisponibleOrigen(BigDecimal saldoDisponibleOrigen) {
		this.saldoDisponibleOrigen = saldoDisponibleOrigen;
	}

	@NotNull
	@Min(value = 0)
	@DecimalMin(value = "0")
	@Digits(integer = 18, fraction = 2)
	public BigDecimal getSaldoDisponibleDestino() {
		return saldoDisponibleDestino;
	}

	public void setSaldoDisponibleDestino(BigDecimal saldoDisponibleDestino) {
		this.saldoDisponibleDestino = saldoDisponibleDestino;
	}

	@NotNull
	@Size(min = 1, max = 10)
	@NotBlank
	@NotEmpty
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

}

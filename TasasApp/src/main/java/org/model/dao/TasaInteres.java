package org.model.dao;

// Generated 16/08/2014 01:49:33 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TasaInteres generated by hbm2java
 */
@Entity
@Table(name = "TASA_INTERES")
public class TasaInteres implements java.io.Serializable {

	private BigDecimal idTasaInteres;
	private String abreviatura;
	private String denominacion;
	private String descripcion;
	private Set valorTasaIntereses = new HashSet(0);

	public TasaInteres() {
	}

	public TasaInteres(BigDecimal idTasaInteres, String abreviatura,
			String denominacion) {
		this.idTasaInteres = idTasaInteres;
		this.abreviatura = abreviatura;
		this.denominacion = denominacion;
	}

	public TasaInteres(BigDecimal idTasaInteres, String abreviatura,
			String denominacion, String descripcion, Set valorTasaIntereses) {
		this.idTasaInteres = idTasaInteres;
		this.abreviatura = abreviatura;
		this.denominacion = denominacion;
		this.descripcion = descripcion;
		this.valorTasaIntereses = valorTasaIntereses;
	}

	@Id
	@Column(name = "ID_TASA_INTERES", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdTasaInteres() {
		return this.idTasaInteres;
	}

	public void setIdTasaInteres(BigDecimal idTasaInteres) {
		this.idTasaInteres = idTasaInteres;
	}

	@Column(name = "ABREVIATURA", nullable = false, length = 10)
	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	@Column(name = "DENOMINACION", nullable = false, length = 30)
	public String getDenominacion() {
		return this.denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	@Column(name = "DESCRIPCION", length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tasaInteres")
	public Set<ValorTasaInteres> getValorTasaIntereses() {
		return this.valorTasaIntereses;
	}

	public void setValorTasaIntereses(Set valorTasaIntereses) {
		this.valorTasaIntereses = valorTasaIntereses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((abreviatura == null) ? 0 : abreviatura.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TasaInteres other = (TasaInteres) obj;
		if (abreviatura == null) {
			if (other.abreviatura != null)
				return false;
		} else if (!abreviatura.equals(other.abreviatura))
			return false;
		return true;
	}

}

package org.softgreen.tasas.model;

// Generated 16/08/2014 01:49:33 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Servicio generated by hbm2java
 */
@Entity
@Table(name = "SERVICIO")
@NamedQueries({ @NamedQuery(name = Servicio.findByDenominacion, query = "SELECT s FROM Servicio s WHERE s.denominacion = :denominacion") })
public class Servicio implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static String findByDenominacion = "Servicio.findByDenominacion";

	private TipoServicio tipoServicio;
	private String denominacion;
	private String descripcion;
	private Set valorTasaIntereses = new HashSet(0);

	private Date version;

	public Servicio() {
	}

	@Id
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "DENOMINACION", unique = true, nullable = false, length = 30)
	public String getDenominacion() {
		return this.denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	@Size(min = 1, max = 100)
	@Column(name = "DESCRIPCION", length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_SERVICIO", nullable = false, foreignKey = @ForeignKey)
	public TipoServicio getTipoServicio() {
		return this.tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "servicio")
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
				+ ((denominacion == null) ? 0 : denominacion.hashCode());
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
		Servicio other = (Servicio) obj;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		return true;
	}

}

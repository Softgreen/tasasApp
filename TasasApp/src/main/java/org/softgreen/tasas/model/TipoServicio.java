package org.softgreen.tasas.model;

// Generated 16/08/2014 01:49:33 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * TipoServicio generated by hbm2java
 */
@Entity
@Table(name = "TIPO_SERVICIO")
@XmlRootElement(name = "tipoServicio")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class TipoServicio implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static String findByDenominacion = "TipoServicio.findByDenominacion";

	private String denominacion;
	private String descripcion;
	private Set servicios = new HashSet(0);

	private Date version;

	public TipoServicio() {
	}

	@Id
	@NotNull
	@NotEmpty
	@NotBlank
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

	@XmlTransient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoServicio")
	public Set<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(Set servicios) {
		this.servicios = servicios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
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
		TipoServicio other = (TipoServicio) obj;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		return true;
	}

}

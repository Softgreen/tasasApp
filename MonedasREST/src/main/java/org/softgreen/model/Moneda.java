package org.softgreen.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Moneda {

	private String codigo;
	private String denominacion;
	private String simbolo;
	private Set<Denominacion> denominaciones = new HashSet<Denominacion>();

	private Timestamp version;

	public Moneda() {
		// TODO Auto-generated constructor stub
	}

	@NotNull
	@Size(min = 1, max = 5)
	@NotBlank
	@NotEmpty
	@Id
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@NotNull
	@Size(min = 1, max = 100)
	@NotBlank
	@NotEmpty
	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	@NotNull
	@Size(min = 1, max = 5)
	@NotBlank
	@NotEmpty
	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "moneda")
	public Set<Denominacion> getDenominaciones() {
		return denominaciones;
	}

	public void setDenominaciones(Set<Denominacion> denominaciones) {
		this.denominaciones = denominaciones;
	}

	@Version
	public Timestamp getVersion() {
		return this.version;
	}

	public void setVersion(Timestamp version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Moneda))
			return false;
		Moneda other = (Moneda) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}

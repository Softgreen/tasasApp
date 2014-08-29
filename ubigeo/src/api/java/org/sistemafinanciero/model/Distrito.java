package org.sistemafinanciero.model;

// Generated 02-may-2014 11:48:28 by Hibernate Tools 4.0.0

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * TipoDocumento generated by hbm2java
 */
@Entity
@Table(name = "DISTRITO")
@XmlRootElement(name = "DISTRITO")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Distrito implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigo;
	private String denominacion;
	private Provincia provincia;

	public Distrito() {
	}

	@NotNull
	@Size(min = 2, max = 2)
	@NotBlank
	@NotEmpty
	@Id
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@NotNull
	@Size(min = 2, max = 2)
	@NotBlank
	@NotEmpty
	@NaturalId
	public String getDenominacion() {
		return this.denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	@XmlTransient
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey)
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

}

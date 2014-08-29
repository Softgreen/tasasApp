package org.sistemafinanciero.model;

// Generated 02-may-2014 11:48:28 by Hibernate Tools 4.0.0

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * TipoDocumento generated by hbm2java
 */
@Entity
@Table(name = "DEPARTAMENTO", schema = "BDSISTEMAFINANCIERO")
@XmlRootElement(name = "departamento")
@XmlAccessorType(XmlAccessType.NONE)
public class Departamento implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigInteger idDepartamento;
	private String denominacion;
	private String abreviatura;
	private String codigo;
	private Set provincias = new HashSet(0);
	
	public Departamento() {
	}

	@XmlElement(name = "id")
	@Id
	@Column(name = "ID_DEPARTAMENTO", unique = true, nullable = false, precision = 22, scale = 0)
	public BigInteger getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(BigInteger idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	@XmlElement
	@Column(name = "DENOMINACION", length = 100, columnDefinition = "nvarchar2")
	public String getDenominacion() {
		return this.denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	@XmlElement
	@Column(name = "ABREVIATURA", length = 5, columnDefinition = "nvarchar2")
	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	@XmlElement
	@Column(name = "CODIGO", length = 3, columnDefinition = "nvarchar2")
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@XmlTransient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
	public Set<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(Set provincias) {
		this.provincias = provincias;
	}

}

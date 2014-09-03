package org.softgreen.organizacion.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(indexes = { @Index(columnList = "id") })
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Caja {

	private Integer id;
	private String denominacion;
	private boolean estado;
	private boolean abierto;
	private boolean estadoMovimiento;

	private Agencia agencia;
	private Set<HistorialCaja> historiales = new HashSet<HistorialCaja>(0);
	private Set<BovedaCaja> bovedaCajas = new HashSet<BovedaCaja>(0);
	private Set<TrabajadorCaja> trabajadorCajas = new HashSet<TrabajadorCaja>(0);

	public Caja() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(generator = "SgGenericGenerator")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	@Size(min = 1, max = 20)
	@NotBlank
	@NotEmpty
	@NaturalId
	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	@NotNull
	@Type(type = "org.hibernate.type.TrueFalseType")
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@NotNull
	@Type(type = "org.hibernate.type.TrueFalseType")
	public boolean isAbierto() {
		return abierto;
	}

	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}

	@NotNull
	@Type(type = "org.hibernate.type.TrueFalseType")
	public boolean isEstadoMovimiento() {
		return estadoMovimiento;
	}

	public void setEstadoMovimiento(boolean estadoMovimiento) {
		this.estadoMovimiento = estadoMovimiento;
	}

	@NotNull
	@NaturalId
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey)
	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	@XmlTransient
	@OneToMany(mappedBy = "caja", fetch = FetchType.LAZY)
	public Set<HistorialCaja> getHistoriales() {
		return historiales;
	}

	public void setHistoriales(Set<HistorialCaja> historiales) {
		this.historiales = historiales;
	}

	@XmlTransient
	@OneToMany(mappedBy = "caja", fetch = FetchType.LAZY)
	public Set<BovedaCaja> getBovedaCajas() {
		return bovedaCajas;
	}

	public void setBovedaCajas(Set<BovedaCaja> bovedaCajas) {
		this.bovedaCajas = bovedaCajas;
	}

	@XmlTransient
	@OneToMany(mappedBy = "caja", fetch = FetchType.LAZY)
	public Set<TrabajadorCaja> getTrabajadorCajas() {
		return trabajadorCajas;
	}

	public void setTrabajadorCajas(Set<TrabajadorCaja> trabajadorCajas) {
		this.trabajadorCajas = trabajadorCajas;
	}

}

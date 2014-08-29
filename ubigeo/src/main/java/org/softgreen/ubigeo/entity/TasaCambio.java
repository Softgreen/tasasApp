package org.softgreen.ubigeo.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.NaturalId;

@Entity
@Table
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class TasaCambio {

	private Long id;
	private Moneda monedaOrigen;
	private Moneda monedaDestino;
	private Date fecha;
	private BigDecimal valor;

	private Timestamp version;

	public TasaCambio() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(generator = "SgGenericGenerator")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@NaturalId
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MONEDA_ORIGEN", foreignKey = @ForeignKey)
	public Moneda getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(Moneda monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	@NotNull
	@NaturalId
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MONEDA_DESTINO", foreignKey = @ForeignKey)
	public Moneda getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(Moneda monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

	@NotNull
	@NaturalId
	@Temporal(TemporalType.DATE)
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@NotNull
	@Min(value = 0)
	@Max(value = 100)
	@DecimalMin(value = "0")
	@DecimalMax(value = "100")
	@Digits(integer = 3, fraction = 2)
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((monedaDestino == null) ? 0 : monedaDestino.hashCode());
		result = prime * result + ((monedaOrigen == null) ? 0 : monedaOrigen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TasaCambio))
			return false;
		TasaCambio other = (TasaCambio) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (monedaDestino == null) {
			if (other.monedaDestino != null)
				return false;
		} else if (!monedaDestino.equals(other.monedaDestino))
			return false;
		if (monedaOrigen == null) {
			if (other.monedaOrigen != null)
				return false;
		} else if (!monedaOrigen.equals(other.monedaOrigen))
			return false;
		return true;
	}

}

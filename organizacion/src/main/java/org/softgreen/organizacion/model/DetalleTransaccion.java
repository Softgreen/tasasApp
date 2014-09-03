package org.softgreen.organizacion.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(indexes = { @Index(columnList = "id") })
public class DetalleTransaccion extends Detalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private BigDecimal valor;
	private int cantidad;

	public DetalleTransaccion() {
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
	@Min(value = 0)
	@Max(value = 1000)
	@DecimalMin(value = "0")
	@DecimalMax(value = "1000")
	@Digits(integer = 4, fraction = 2)
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@NotNull
	@Min(value = 0)
	@DecimalMin(value = "0")
	@Digits(integer = 18, fraction = 2)
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}

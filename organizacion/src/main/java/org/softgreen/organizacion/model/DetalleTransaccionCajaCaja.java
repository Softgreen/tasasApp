package org.softgreen.organizacion.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("CajaCaja")
public class DetalleTransaccionCajaCaja extends DetalleTransaccion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TransaccionCajaCaja transaccionCajaCaja;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey)
	public TransaccionCajaCaja getTransaccionCajaCaja() {
		return transaccionCajaCaja;
	}

	public void setTransaccionCajaCaja(TransaccionCajaCaja transaccionCajaCaja) {
		this.transaccionCajaCaja = transaccionCajaCaja;
	}

}

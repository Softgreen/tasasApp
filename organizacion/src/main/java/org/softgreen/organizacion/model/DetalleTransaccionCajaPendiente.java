package org.softgreen.organizacion.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("PendienteCaja")
public class DetalleTransaccionCajaPendiente extends DetalleTransaccion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PendienteCaja pendienteCaja;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey)
	public PendienteCaja getPendienteCaja() {
		return pendienteCaja;
	}

	public void setPendienteCaja(PendienteCaja pendienteCaja) {
		this.pendienteCaja = pendienteCaja;
	}

}

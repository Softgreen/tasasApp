package org.softgreen.organizacion.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BovedaCaja")
public class DetalleTransaccionBovedaCaja extends DetalleTransaccion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}

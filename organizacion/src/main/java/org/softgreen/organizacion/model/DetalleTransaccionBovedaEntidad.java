package org.softgreen.organizacion.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BovedaEntidad")
public class DetalleTransaccionBovedaEntidad extends DetalleTransaccion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

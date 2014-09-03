package org.softgreen.organizacion.model;

public class TransaccionInterna extends Transaccion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Historial historial;
	private boolean estadoSolicitud;
	private boolean estadoConfirmacion;

}

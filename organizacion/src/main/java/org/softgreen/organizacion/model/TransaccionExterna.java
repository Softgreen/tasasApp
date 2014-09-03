package org.softgreen.organizacion.model;

public class TransaccionExterna extends Transaccion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long numeroOperacion;

	public TransaccionExterna() {
		// TODO Auto-generated constructor stub
	}

	public Long getNumeroOperacion() {
		return numeroOperacion;
	}

	public void setNumeroOperacion(Long numeroOperacion) {
		this.numeroOperacion = numeroOperacion;
	}

}

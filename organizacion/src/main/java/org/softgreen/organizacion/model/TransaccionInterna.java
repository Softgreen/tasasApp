package org.softgreen.organizacion.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@MappedSuperclass
public abstract class TransaccionInterna implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Date fecha;
	private Date hora;
	private boolean estado;
	private String observacion;

	private boolean estadoSolicitud;
	private boolean estadoConfirmacion;

	private Set<DetalleTransaccionInterna> detalle = new HashSet<DetalleTransaccionInterna>();

	public TransaccionInterna() {
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
	@Temporal(TemporalType.DATE)
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
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
	@Size(min = 0, max = 60)
	@NotBlank
	@NotEmpty
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@NotNull
	@Type(type = "org.hibernate.type.TrueFalseType")
	public boolean isEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(boolean estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	@NotNull
	@Type(type = "org.hibernate.type.TrueFalseType")
	public boolean isEstadoConfirmacion() {
		return estadoConfirmacion;
	}

	public void setEstadoConfirmacion(boolean estadoConfirmacion) {
		this.estadoConfirmacion = estadoConfirmacion;
	}

	@XmlTransient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transaccionInterna")
	public Set<DetalleTransaccionInterna> getDetalle() {
		return detalle;
	}

	public void setDetalle(Set<DetalleTransaccionInterna> detalle) {
		this.detalle = detalle;
	}

}

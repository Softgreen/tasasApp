package org.softgreen.persona.entity;

// Generated 02-may-2014 11:48:28 by Hibernate Tools 4.0.0

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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

/**
 * Accionista generated by hbm2java
 */
@Entity
@Table
@XmlRootElement(name = "accionista")
@XmlAccessorType(XmlAccessType.NONE)
public class Accionista implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private PersonaNatural personaNatural;
	private PersonaJuridica personaJuridica;
	private BigDecimal porcentajeParticipacion;

	public Accionista() {

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
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey)
	public PersonaNatural getPersonaNatural() {
		return personaNatural;
	}

	public void setPersonaNatural(PersonaNatural personaNatural) {
		this.personaNatural = personaNatural;
	}

	@NotNull
	@NaturalId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey)
	public PersonaJuridica getPersonaJuridica() {
		return personaJuridica;
	}

	public void setPersonaJuridica(PersonaJuridica personaJuridica) {
		this.personaJuridica = personaJuridica;
	}

	@NotNull
	@Min(value = 1)
	@Max(value = 100)
	@DecimalMin(value = "1")
	@DecimalMax(value = "100")
	@Digits(integer = 3, fraction = 2)
	public BigDecimal getPorcentajeParticipacion() {
		return porcentajeParticipacion;
	}

	public void setPorcentajeParticipacion(BigDecimal porcentajeParticipacion) {
		this.porcentajeParticipacion = porcentajeParticipacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personaJuridica == null) ? 0 : personaJuridica.hashCode());
		result = prime * result + ((personaNatural == null) ? 0 : personaNatural.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Accionista))
			return false;
		Accionista other = (Accionista) obj;
		if (personaJuridica == null) {
			if (other.personaJuridica != null)
				return false;
		} else if (!personaJuridica.equals(other.personaJuridica))
			return false;
		if (personaNatural == null) {
			if (other.personaNatural != null)
				return false;
		} else if (!personaNatural.equals(other.personaNatural))
			return false;
		return true;
	}

}

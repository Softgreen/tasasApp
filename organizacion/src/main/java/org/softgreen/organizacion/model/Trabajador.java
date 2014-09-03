package org.softgreen.organizacion.model;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(indexes = { @Index(columnList = "id") })
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Trabajador {

	private Integer idTrabajador;
	private PersonaNatural personaNatural;
	private Agencia agencia;
	private int estado;
	private String usuario;
	private Set trabajadorCajas = new HashSet(0);

}

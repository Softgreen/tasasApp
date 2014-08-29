package org.softgreen.ubigeo.controller;

import java.util.List;
import java.util.TreeSet;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.softgreen.dao.CrudService;
import org.softgreen.ubigeo.entity.Departamento;
import org.softgreen.ubigeo.entity.Distrito;
import org.softgreen.ubigeo.entity.Pais;
import org.softgreen.ubigeo.entity.Provincia;

@Stateless
public class UbigeoController {

	@Inject
	private CrudService crudService;

	public TreeSet<Pais> getPaises() {
		List<Pais> result = crudService.findWithNamedQuery(Pais.findAll);
		return new TreeSet<Pais>(result);
	}
	
	public get

	public Departamento getDepartamento(String codigoDepartamento) {
		crudService.findWithNamedQuery()
		return null;
	}

	public TreeSet<Departamento> getDepartamentos() {
		return null;
	}

	public TreeSet<Provincia> getProvincias(String codigoDepartamento) {
		return null;
	}

	public Provincia getProvincia(String codigoDepartamento, String codigoProvincia) {
		return null;
	}

	public TreeSet<Distrito> getDistritos(String codigoDepartamento, String codigoProvincia) {
		return null;
	}

	public Distrito getDistrito(String codigoDepartamento, String codigoProvincia, String codigoDistrito) {
		return null;
	}

}

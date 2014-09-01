package org.softgreen.ubigeo.controller;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.softgreen.dao.CrudService;
import org.softgreen.dao.DAO;
import org.softgreen.ubigeo.entity.Departamento;
import org.softgreen.ubigeo.entity.Distrito;
import org.softgreen.ubigeo.entity.Pais;
import org.softgreen.ubigeo.entity.Provincia;

@Stateless
public class UbigeoController {

	@Inject
	private DAO<String, Pais> paisDAO;
	
	@Inject
	private DAO<String, Departamento> departamentoDAO;
	
	@Inject
	private DAO<String, Provincia> provinciaDAO;
	
	@Inject
	private DAO<String, Distrito> distritoDAO;
	
		
	public TreeSet<Pais> getPaises() {
		Collection<Pais> result = paisDAO.findByNamedQuery(Pais.findAll);
		return new TreeSet<Pais>(result);
	}
	
	public Pais getPais(String codigo){
		return paisDAO.find(codigo);
	}

	public TreeSet<Departamento> getDepartamentos() {
		Collection<Departamento> result = departamentoDAO.findByNamedQuery(Departamento.findAll);
		return new TreeSet<Departamento>(result);
	}
	
	public Departamento getDepartamento(String codigoDepartamento) {
		return departamentoDAO.find(codigoDepartamento);
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

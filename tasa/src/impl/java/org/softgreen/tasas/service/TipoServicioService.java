package org.softgreen.tasas.service;

import javax.ejb.Remote;

import org.softgreen.tasas.model.TipoServicio;

@Remote
public interface TipoServicioService extends
		AbstractService<String, TipoServicio> {

}

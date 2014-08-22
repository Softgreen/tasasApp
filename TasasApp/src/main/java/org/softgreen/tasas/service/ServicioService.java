package org.softgreen.tasas.service;

import javax.ejb.Remote;

import org.softgreen.tasas.model.Servicio;

@Remote
public interface ServicioService extends AbstractService<Integer, Servicio> {

}

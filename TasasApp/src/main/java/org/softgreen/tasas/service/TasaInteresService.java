package org.softgreen.tasas.service;

import javax.ejb.Remote;

import org.softgreen.tasas.model.TasaInteres;

@Remote
public interface TasaInteresService extends
		AbstractService<Integer, TasaInteres> {

}

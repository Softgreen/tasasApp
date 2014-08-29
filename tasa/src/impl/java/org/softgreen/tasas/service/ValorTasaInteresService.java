package org.softgreen.tasas.service;

import javax.ejb.Remote;

import org.softgreen.tasas.model.ValorTasaInteres;

@Remote
public interface ValorTasaInteresService extends
		AbstractService<Long, ValorTasaInteres> {

}

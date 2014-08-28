package org.softgreen.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;

@Named
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class MonedaService {

	
}

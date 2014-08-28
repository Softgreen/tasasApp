/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.softgreen.tasas.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;
import org.softgreen.tasas.rest.impl.ClienteRESTService;
import org.softgreen.tasas.rest.impl.ServicioRESTService;
import org.softgreen.tasas.rest.impl.TasaInteresRESTService;
import org.softgreen.tasas.rest.impl.TipoServicioRESTService;
import org.softgreen.tasas.rest.impl.ValorTasaInteresRESTService;

/**
 * A class extending {@link Application} and annotated with @ApplicationPath is
 * the Java EE 6 "no XML" approach to activating JAX-RS.
 * 
 * <p>
 * Resources are served relative to the servlet path specified in the
 * {@link ApplicationPath} annotation.
 * </p>
 */
@ApplicationPath("/rest")
public class JaxRsActivator extends Application {

	private Set<Object> singletons = new HashSet<>();

	@Override
	public Set<Object> getSingletons() {
		CorsFilter filter = new CorsFilter();
		filter.getAllowedOrigins().add("http://localhost");
		singletons.add(filter);
		return singletons;
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(ServicioRESTService.class);
		classes.add(TipoServicioRESTService.class);
		classes.add(TasaInteresRESTService.class);
		classes.add(ValorTasaInteresRESTService.class);
		classes.add(ClienteRESTService.class);
		return classes;
	}
}

package br.com.fiap.aspectj;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public abstract aspect AbstractLogging {

	public abstract pointcut logPoints();

	public abstract Logger getLogger();

	before() : logPoints() {
		getLogger().log(Level.INFO, "Antes de cada regra de negocio: " + thisJoinPoint);

	}
}

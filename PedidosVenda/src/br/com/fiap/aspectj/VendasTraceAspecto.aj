package br.com.fiap.aspectj;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import br.com.fiap.dao.VendaDao;

public aspect VendasTraceAspecto {

	/*
	 * 1.Gerar log de auditoria antes e depois de cada regra de negócio
	 * executada.
	 */

	private int _callDepth = -1;

	//pointcut tracePoints() : ! within ( VendasTraceAspecto ) ;
	pointcut tracePoints() :  within ( VendasTraceAspecto ) ;

	before() : tracePoints()
{
		_callDepth++;
		print("Before", thisJoinPoint);
	}

	after() : tracePoints()
{
		print("After", thisJoinPoint);
		Logger logger = Logger.getLogger(this.getClass());
		Logger.getLogger(this.getClass());
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Regra de negocio executada" + this.getClass());
		
		System.out.println("Classe" + thisJoinPoint.getThis());
		
		_callDepth--;
	}

	private void print(String prefix, Object message) {
		for (int i = 0, spaces = _callDepth * 2; i < spaces; i++) {
			System.out.print(" ");
		}
		System.out.println(prefix + ": " + message);
	}
}

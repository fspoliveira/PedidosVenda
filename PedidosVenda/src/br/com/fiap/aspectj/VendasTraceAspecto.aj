package br.com.fiap.aspectj;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.Signature;

import br.com.fiap.dao.VendaDao;

public aspect VendasTraceAspecto {

	/*
	 * 1.Gerar log de auditoria antes e depois de cada regra de negócio
	 * executada.
	 */
		
	private int _callDepth = -1;

	pointcut tracePoints() : ! within ( VendasTraceAspecto ) ;	

	before() : tracePoints()
{
		_callDepth++;
		print("Before", thisJoinPoint);
		
		Logger logger = Logger.getLogger(thisJoinPoint.getStaticPart().getSourceLocation().getWithinType().getPackage().getName()
				.concat(".").concat(thisJoinPoint.getSourceLocation().getFileName().replace(".java", ".class")));
		Logger.getLogger(this.getClass());
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Log de auditoria antes da regra de negócio ser executada: " + thisJoinPoint.getClass());
	}

	after() : tracePoints()
{
		print("After", thisJoinPoint);
		Logger logger = Logger.getLogger(thisJoinPoint.getStaticPart().getSourceLocation().getWithinType().getPackage().getName()
				.concat(".").concat(thisJoinPoint.getSourceLocation().getFileName().replace(".java", ".class")));
		Logger.getLogger(this.getClass());
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Log de auditoria depois da regra de negócio ser executada: " + thisJoinPoint.getClass());
		
		_callDepth--;
	}

	private void print(String prefix, Object message) {
		for (int i = 0, spaces = _callDepth * 2; i < spaces; i++) {
			System.out.print(" ");
		}
		System.out.println(prefix + ": " + message);
	}
}
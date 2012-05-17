package br.com.fiap.aspectj;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.*;

import br.com.fiap.dao.VendaDao;



public aspect ExceptionLogger {
	
	pointcut exceptionLogMethods()	: call(* *.*(..)) && !within(ExceptionLogger);
	
	
	after() throwing(Throwable ex) : exceptionLogMethods() {
	Signature sig = thisJoinPointStaticPart.getSignature();
	System.err.println("Exception logger aspect ["
	+ sig.getDeclaringType().getName() + "."
	+ sig.getName() + "]");
	ex.printStackTrace(System.err);
	
	Logger logger = Logger.getLogger(VendaDao.class);	
	
	PropertyConfigurator.configure("log4j.properties");
	logger.error("Exception:" +sig.getDeclaringType().getName() );
	
	
	}
}

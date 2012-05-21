package br.com.fiap.aspectj;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.*;

public aspect ExceptionLogger {

	pointcut exceptionLogMethods()	: call(* *.*(..)) && !within(ExceptionLogger);

	after() throwing(Throwable ex) : exceptionLogMethods() {
		Signature sig = thisJoinPointStaticPart.getSignature();
		System.err.println("Exception logger aspect ["
				+ sig.getDeclaringType().getName() + "." + sig.getName() + "]");
		ex.printStackTrace(System.err);
	
		Logger logger = Logger.getLogger(thisJoinPoint.getStaticPart().getSourceLocation().getWithinType().getPackage().getName()
				.concat(".").concat(thisJoinPoint.getSourceLocation().getFileName().replace(".java", ".class")));
		
		PropertyConfigurator.configure("log4j.properties");
		logger.error("Exception:" + sig.getDeclaringType().getName());

	}
}
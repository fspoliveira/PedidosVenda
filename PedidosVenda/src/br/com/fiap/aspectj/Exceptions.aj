package br.com.fiap.aspectj;
import org.apache.log4j.Logger;

public aspect Exceptions {

	pointcut publicCall(): call(public Object *(..));

	after() throwing (Exception e): publicCall() {
		System.out.println("Threw an exception: " + e);
		
		/*5. Logar todas as Exceções ocorridas no Projeto através de
		Aspectos*/
		
		Logger.getLogger(this.getClass()).error(e.getMessage(), e);
	}
	
}
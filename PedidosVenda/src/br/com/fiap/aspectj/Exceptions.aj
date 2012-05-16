package br.com.fiap.aspectj;

public aspect Exceptions {

	pointcut publicCall(): call(public Object *(..));

	after() throwing (Exception e): publicCall() {
		System.out.println("Threw an exception: " + e);
	}
	
}
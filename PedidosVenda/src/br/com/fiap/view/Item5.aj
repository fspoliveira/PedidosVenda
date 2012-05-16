package br.com.fiap.view;

public aspect Item5 {

	pointcut publicCall(): call(public Object *(..));

	after() throwing (Exception e): publicCall() {
		System.out.println("Threw an exception: " + e);
	}
	
}
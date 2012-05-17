package br.com.fiap.aspectj;

import br.com.fiap.view.RegistroPedidos;

public aspect DescontoMaisDe10Itens {	
	pointcut modifiqueValor(Double total, int linha):
		call(* RegistroPedidos.calculaTotal(Double, int)) &&
		args(total, linha);
	
	  Double around (Double total, int linha) : modifiqueValor(total, linha){
		if(linha > 10){
			System.out.println("DESCONTO FDP");
			 return proceed(total, linha);
		}else{
			return proceed(total, linha);
		}
	}
}

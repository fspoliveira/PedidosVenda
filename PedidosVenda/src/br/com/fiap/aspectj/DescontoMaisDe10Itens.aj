package br.com.fiap.aspectj;

import br.com.fiap.view.RegistroPedidos;

public aspect DescontoMaisDe10Itens {
	pointcut modifiqueValor(Double total, int linha):
		call(* RegistroPedidos.calculaTotal(Double, int)) &&
		args(total, linha);

	Double around(Double total, int linha) : modifiqueValor(total, linha){
		if (linha > 11) {

			/*
			 * b) Se o cliente comprar mais de 10 itens de pedidos terá
			 * automaticamente um desconto de 5% do valor total
			 */

			Double desconto = total - (total * 0.05);

			return proceed(desconto, linha);
		} else {
			return proceed(total, linha);
		}
	}
}
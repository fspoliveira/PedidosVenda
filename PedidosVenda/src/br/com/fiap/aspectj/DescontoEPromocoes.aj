package br.com.fiap.aspectj;

import br.com.fiap.view.RegistroPedidos;

public aspect DescontoEPromocoes {
	pointcut modifiqueValor(Double total, int qtdItems):
		call(* RegistroPedidos.calculaTotal(Double, int)) &&
		args(total, qtdItems);

	Double around(Double total, int qtdItems) : modifiqueValor(total, qtdItems){
		if (qtdItems > 10) {

			/*
			 * b) Se o cliente comprar mais de 10 itens de pedidos terá
			 * automaticamente um desconto de 5% do valor total
			 */

			Double desconto = total - (total * 0.05);

			return proceed(desconto, qtdItems);
		} else {
			return proceed(total, qtdItems);
		}
	}
}
package br.com.fiap.aspectj;

import br.com.fiap.view.RegistroPedidos;

public aspect VendaMaiorQue1000Desconto5PCItem {
	pointcut modifiqueValor(Double total):
		call(* RegistroPedidos.calculaTotal(Double)) &&
		args(total);

	Double around(Double total) : modifiqueValor(total){
		if (total > 1000) {

			/*a) Toda venda maior que R$ 1.000,00 terá desconto de 5% do
				   valor em cada item;*/
			
			System.out.println("Desconto de 5% em cima de cada Item");

			return proceed(total);
		} else {
			return proceed(total);
		}
	}
}

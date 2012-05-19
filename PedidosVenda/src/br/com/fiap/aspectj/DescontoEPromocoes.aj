package br.com.fiap.aspectj;

import java.util.List;

import br.com.fiap.view.RegistroPedidos;
import br.com.fiap.model.Produto;

public aspect DescontoEPromocoes {
	pointcut modifiqueValor(Double total, int qtdItems,
			List<Produto> listProdutos2):
		call(* RegistroPedidos.calculaTotal(Double, int, List<Produto>)) &&
		args(total, qtdItems, listProdutos2 );

	Double around(Double total, int qtdItems, List<Produto> listProdutos2) : modifiqueValor(total, qtdItems,listProdutos2){
		/*
		 * b) Se o cliente comprar mais de 10 itens de pedidos terá
		 * automaticamente um desconto de 5% do valor total
		 */
		
		 

		if (qtdItems > 10) {

			Double descontoTotal = total - (total * 0.05);

			return proceed(descontoTotal, qtdItems, listProdutos2);
			
		} else if (total > 1000) {
			
			/*a) Toda venda maior que R$ 1.000,00 terá desconto de 5% do
				   valor em cada item;*/
			
			Double descontoItem = 0.05;
			
			System.out.println("Desconto nos itens de 5%?");
			return proceed(descontoItem, qtdItems, listProdutos2);
		}
		return proceed(total, qtdItems, listProdutos2);
		
	}
}
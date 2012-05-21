package br.com.fiap.aspectj;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import br.com.fiap.view.RegistroPedidos;
import br.com.fiap.model.Produto;

public aspect DescontoEPromocoes {
	pointcut modifiqueValor(Double total, int qtdItems,
			List<Produto> listProdutos2, GregorianCalendar dataPedido):
		call(* RegistroPedidos.calculaTotal(Double, int, List<Produto>, GregorianCalendar)) &&
		args(total, qtdItems, listProdutos2, dataPedido );

	Double around(Double total, int qtdItems, List<Produto> listProdutos2,
			GregorianCalendar dataPedido) : modifiqueValor(total, qtdItems,listProdutos2,dataPedido){

		int mesPedido = dataPedido.get(Calendar.MONTH);
		int diaSemana = dataPedido.get(Calendar.DAY_OF_WEEK);

		/*
		 * a) Toda venda maior que R$ 1.000,00 terá desconto de 5% do valor em
		 * cada item;
		 */

		if (total > 1000) {

			Double descontoItem = 0.05;
			Produto prod = new Produto();

			for (int i = 0; i < listProdutos2.size(); i++) {

				prod = listProdutos2.get(i);
				prod.setDescontoProduto(descontoItem);
				listProdutos2.set(i, prod);
			}

			System.out.println("Desconto nos itens de 5%?");
			return proceed(total, qtdItems, listProdutos2, dataPedido);
		}

		/*
		 * b) Se o cliente comprar mais de 10 itens de pedidos terá
		 * automaticamente um desconto de 5% do valor total
		 */

		if (qtdItems > 10) {

			Double descontoTotal = total - (total * 0.05);

			return proceed(descontoTotal, qtdItems, listProdutos2, dataPedido);
		}

		/*
		 * c) Para pedidos emitidos entre os meses de Agosto e Setembro deverá
		 * ser adicionado um adicional de 10% do total do valor total do pedido
		 */

		if ((mesPedido == 7) || (mesPedido == 8)) {

			Double adicionalTotal = total + (total * 0.05);
			return proceed(adicionalTotal, qtdItems, listProdutos2, dataPedido);
		}

		/*
		 * d) Para pedidos realizados aos domingos os mesmos estarão sob efeito
		 * de promoção, isto é, desconto de R$ 100,00, isso somente para a
		 * compra do livro de “AspectJ – a arte de Pensar Diferente”
		 */

		if (diaSemana == 1) {

			Produto prod = new Produto();
			Double desconto = 100.0;

			for (int i = 0; i < listProdutos2.size(); i++) {

				prod = listProdutos2.get(i);

				if (prod.getDescricao().equals(
						"AspectJ – a arte de Pensar Diferente")) {

					prod.setDescontoProduto(desconto);
					listProdutos2.set(i, prod);
				}

			}

			return proceed(total, qtdItems, listProdutos2, dataPedido);

		}

		return proceed(total, qtdItems, listProdutos2, dataPedido);
	}
}
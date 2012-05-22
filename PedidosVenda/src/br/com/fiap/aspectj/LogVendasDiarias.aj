package br.com.fiap.aspectj;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import br.com.fiap.view.RegistroPedidos;

public aspect LogVendasDiarias {

	pointcut createLogDailySalesOrder(Integer pedido, Double totalPedido,
			Integer qtdeItems):
		call(* RegistroPedidos.Total(Integer, Double, Integer)) &&
		args(pedido, totalPedido, qtdeItems );

	void around(Integer pedido, Double totalPedido, Integer qtdeItems) 
	: createLogDailySalesOrder(pedido, totalPedido,qtdeItems){

		/*
		 * 2. Gerar log de vendas diárias contendo a quantidade e valores totais
		 * dos pedidos gerados.
		 */

		Logger logger = Logger.getLogger(RegistroPedidos.class);
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Pedido: " + pedido + " Total do Pedido: " + totalPedido
				+ " Quantidade de Ítens " + qtdeItems + " Usuário: "
				+ System.getProperty("user.name"));
	}
}
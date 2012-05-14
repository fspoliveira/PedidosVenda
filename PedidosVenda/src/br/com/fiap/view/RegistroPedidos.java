package br.com.fiap.view;

import java.util.Iterator;
import java.util.SortedMap;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.controller.ClienteController;
import br.com.fiap.controller.ProdutoController;
import br.com.fiap.controller.TipoClienteController;
import br.com.fiap.model.Produto;

public class RegistroPedidos {
	protected Shell shell;
	private Text text;
	private Table table;
	private Text txt_qtd;
	public Text txtR;
	private Double total;

	Iterator<String> iterator;
	private SortedMap<String, String> produtos;
	private SortedMap<String, String> tipoCliente;
	private SortedMap<String, String> clientes;

	public static void main(String[] args) {
		try {
			RegistroPedidos window = new RegistroPedidos();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		shell = new Shell();
		shell.setSize(730, 525);
		shell.setText("Registro de Pedidos");
		shell.setLayout(null);

		Label lblNroPedido = new Label(shell, SWT.NONE);
		lblNroPedido.setBounds(44, 25, 87, 26);
		lblNroPedido.setText("Nro. Pedido");

		text = new Text(shell, SWT.BORDER | SWT.RIGHT);
		text.setBounds(137, 22, 92, 29);
		text.setEditable(false);

		Label lblData = new Label(shell, SWT.NONE);
		lblData.setBounds(254, 25, 68, 21);
		lblData.setText("Data");

		final DateTime dateTime = new DateTime(shell, SWT.DATE);
		dateTime.setBounds(306, 25, 104, 21);

		Label lblTipoCliente = new Label(shell, SWT.NONE);
		lblTipoCliente.setBounds(44, 69, 87, 26);
		lblTipoCliente.setText("Tipo Cliente");

		final Combo tipoCliente_cmb = new Combo(shell, SWT.NONE);
		tipoCliente_cmb.setBounds(137, 66, 93, 29);

		// Adiciona os tipos de clientes do banco de dados
		TipoClienteController tipoClienteC = new TipoClienteController();
		tipoCliente = tipoClienteC.getTipoClientes();
		tipoCliente_cmb.add("Selecione o tipo do Cliente");

		iterator = tipoCliente.keySet().iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			tipoCliente_cmb.add(tipoCliente.get(key),
					Integer.parseInt(key.toString()));
		}

		Label lblCliente = new Label(shell, SWT.NONE);
		lblCliente.setBounds(44, 110, 68, 26);
		lblCliente.setText("Cliente");

		final Combo cliente_cmb = new Combo(shell, SWT.NONE);
		cliente_cmb.setBounds(137, 110, 387, 29);
		
		//Adiciona clientes do banco de dados
		ClienteController clienteC = new ClienteController();
		clientes = clienteC.getClientes();
		cliente_cmb.add("Selecione o cliente");
		
		iterator = clientes.keySet().iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			cliente_cmb.add(clientes.get(key),
					Integer.parseInt(key.toString()));
		}
		
		Label lblProduto = new Label(shell, SWT.NONE);
		lblProduto.setBounds(44, 157, 68, 21);
		lblProduto.setText("Produto");

		final Combo produto_cmb = new Combo(shell, SWT.NONE);
		produto_cmb.setBounds(137, 149, 387, 29);

		// Adiciona todos produtos do Banco de Dados
		ProdutoController pc = new ProdutoController();
		produtos = pc.getProdutos();

		produto_cmb.add("Selecione o produto", 0);

		iterator = produtos.keySet().iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();			
			produto_cmb
					.add(produtos.get(key), Integer.parseInt(key.toString()));
		}

		table = new Table(shell, SWT.BORDER | SWT.CHECK | SWT.FULL_SELECTION);
		table.setBounds(44, 219, 635, 212);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnIdProduto = new TableColumn(table, SWT.NONE);
		tblclmnIdProduto.setWidth(100);
		tblclmnIdProduto.setText("Id Produto");

		TableColumn tblclmnDescProduto = new TableColumn(table, SWT.NONE);
		tblclmnDescProduto.setWidth(185);
		tblclmnDescProduto.setText("Desc Produto");

		TableColumn tblclmnVlrUnitario = new TableColumn(table, SWT.NONE);
		tblclmnVlrUnitario.setWidth(100);
		tblclmnVlrUnitario.setText("Vlr. Unitario");

		TableColumn tblclmnQde = new TableColumn(table, SWT.NONE);
		tblclmnQde.setWidth(53);
		tblclmnQde.setText("Qde");

		TableColumn tblclmnDesconto = new TableColumn(table, SWT.NONE);
		tblclmnDesconto.setWidth(100);
		tblclmnDesconto.setText("Desconto");

		TableColumn tblclmnTotal = new TableColumn(table, SWT.NONE);
		tblclmnTotal.setWidth(100);
		tblclmnTotal.setText("Total");

		Label lblQuantidade = new Label(shell, SWT.NONE);
		lblQuantidade.setBounds(545, 157, 79, 21);
		lblQuantidade.setText("Quantidade");

		txt_qtd = new Text(shell, SWT.BORDER | SWT.RIGHT);
		txt_qtd.setBounds(630, 154, 63, 29);
		txt_qtd.setText("1");

		Button btnAdicionarProduto = new Button(shell, SWT.NONE);
		btnAdicionarProduto.setBounds(44, 190, 136, 23);
		btnAdicionarProduto.setText("Adicionar produto");

		btnAdicionarProduto.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				TableItem it1 = new TableItem(table, SWT.NONE);

				ProdutoController p = new ProdutoController();
				Produto produto = p.getProduto(produto_cmb.getSelectionIndex());

				it1.setText(new String[] {
						Integer.toString(produto_cmb.getSelectionIndex()),
						produto_cmb.getText(),
						Double.toString(produto.getValorUnitario()),
						txt_qtd.getText(),
						"0",
						Double.toString(Integer.parseInt(txt_qtd.getText())
								* produto.getValorUnitario()) });

				getGrid();
				calculaTotal(total);
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		txtR = new Text(shell, SWT.BORDER | SWT.RIGHT);
		txtR.setBounds(526, 184, 150, 29);
		txtR.setEditable(false);

		Button btnCheckButton = new Button(shell, SWT.CHECK);
		btnCheckButton.setBounds(44, 447, 104, 16);
		btnCheckButton.setSelection(false);
		btnCheckButton.setText("Finalizado");

		btnCheckButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {

				finalizado();
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION
						| SWT.YES | SWT.NO);
				messageBox.setText("Atenção");
				messageBox.setMessage("Deseja finalizar o pedido?");

				int buttonID = messageBox.open();

				switch (buttonID) {

				case SWT.YES:
					

				case SWT.NO:
					//System.exit(0);
					
				}
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		Label lblTotalGeral = new Label(shell, SWT.NONE);
		lblTotalGeral.setBounds(429, 194, 91, 19);
		lblTotalGeral.setText("TOTAL GERAL");

	}

	public Double calculaTotal(Double total) {
		Double valor = 0.00;
		TableItem[] selection = table.getItems();
		for (int i = 0; i < selection.length; i++) {
			valor = valor + Double.parseDouble(selection[i].getText(5));
		}

		txtR.setText(total.toString());
		return total;
	}

	public void adicionaProd() {
		System.out.println("Metodo Adiciona Produto");
	}

	public void finalizado() {
	}

	public void getGrid() {

		total = 0.00;
		TableItem[] selection = table.getItems();
		for (int i = 0; i < selection.length; i++) {
			total = total + Double.parseDouble(selection[i].getText(5));
		}
		total = calculaTotal(total);

	}
}
package br.com.treinamento.pizzaria.modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import br.com.treinamento.pizzaria.util.DataUtil;

public class Pedido {

	public static final String TIPO_PIZZA = "Pizza";
	public static final String TIPO_REFRIGERANTE = "Refrigerante";
	public static final String TIPO_PIZZA_COM_BORDA = "Borda Recheada";

	private Integer codigo;
	private String cliente;
	private String telefone;
	private String item;
	private String tipo;
	private Double valorItem;
	private Double totalPedido = 0.0;
	private String relatorio = "";
	private List<ItemPedido> itensPedido;
	Estoque estoque = new Estoque(10, 10);

	public Pedido(Integer codigo, String cliente, String telefone, List<ItemPedido> itensPedido) {
		this.codigo = codigo;
		this.cliente = cliente;
		this.telefone = telefone;
		this.itensPedido = itensPedido;
	}

	public Pedido(String item, String tipo, Double valor) {
		this.item = item;
		this.tipo = tipo;
		this.valorItem = valor;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public String getTelefone() {
		return telefone;

	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public String getItem() {
		return item;
	}

	public String getTipo() {
		return tipo;
	}

	public Double getValor() {
		return valorItem;
	}

	private void informaDadosPedido() {

		String dadosPedido = "";
		String dadosItens = "";

		dadosPedido += "Número do Pedido: " + this.codigo + "\n";
		dadosPedido += "Data do Pedido: " + DataUtil.formataDataPadraoBrasil(new Date()) + "\n";
		dadosPedido += "Nome do Cliente: " + this.cliente + "\n";
		dadosPedido += "Telefone: " + this.telefone + "\n";
		dadosPedido += "Quantidade de Itens: " + this.itensPedido.size() + "\n";

		for (ItemPedido itensPedido : itensPedido) {

			dadosItens += "\nPedido de : " + itensPedido.getItem() + "\n";
			dadosItens += "Valor: R$ " + itensPedido.getValor() + "\n";
		}

		System.out.print(dadosPedido + dadosItens);
		this.relatorio += dadosPedido + dadosItens;
	}

	private void darBrinde() {
		Integer quantidadeDePizza = 0;

		for (ItemPedido itensPedido : itensPedido) {
			if (itensPedido.getTipo().equals(ItemPedido.TIPO_PIZZA)) {
				quantidadeDePizza++;
			}
		}
		if (quantidadeDePizza >= 2) {
			ItemPedido itemBrinde = new ItemPedido("Refrigerante Dolly", ItemPedido.TIPO_REFRIGERANTE, 0.0);
			itensPedido.add(itemBrinde);
			System.out.println("\nVocê ganhou um " + itemBrinde.getItem());
			this.relatorio += "\nPedido bonificado com um " + itemBrinde.getItem();
		}
	}

	private void calculaPedido() {
		String total = "";

		for (ItemPedido itensPedido : itensPedido) {
			this.totalPedido += itensPedido.getValor();
		}

		total += "\nO valor total do pedido é: R$ " + this.totalPedido + "\n";
		System.out.println(total);
		this.relatorio += "\n" + total + "\n";
	}

	private void rejeitaPizza() {
		for (ItemPedido itensPedido : itensPedido) {
			if (itensPedido.getTipo().equals(ItemPedido.TIPO_PIZZA) && itensPedido.getItem().contains("Atum")) {
				throw new RuntimeException("Estamos sem Pizza de Atum!\n");
			}
		}
	}

	private void geraRelatorio() {

		try {

			FileWriter arquivo = new FileWriter(
					"C:\\Users\\aleixo\\Documents\\ESTUDOS TI\\Curso Java - Allan\\relatorioDeVenda.doc");

			arquivo.write(this.relatorio);
			arquivo.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private void verificaBordaRecheada() {
		Integer pizzaComBorda = 0;
		String borda = "";

		for (ItemPedido itensPedido : itensPedido) {
			if (itensPedido.getTipo().equals(ItemPedido.TIPO_PIZZA_COM_BORDA)) {
				this.totalPedido += 3.0;
				pizzaComBorda++;
			}
		}

		if (pizzaComBorda > 0) {

			borda += "\nFoi acrescentado + R$ " + pizzaComBorda * 3 + ",00 pela(s) borda(s) recheada(a)!";
			System.out.println(borda);
			this.relatorio += borda + "\n";
		}
	}

	private void verificaEstoque() {

		Integer quantidadeDePizza = 0;
		Integer quantidadeDeRefrigerante = 0;

		for (ItemPedido itensPedido : itensPedido) {
			if (itensPedido.getTipo().equals(ItemPedido.TIPO_PIZZA)) {
				quantidadeDePizza++;
			}

			if (itensPedido.getTipo().equals(ItemPedido.TIPO_PIZZA_COM_BORDA)) {
				quantidadeDePizza++;
			}

			if (itensPedido.getTipo().equals(ItemPedido.TIPO_REFRIGERANTE)) {
				quantidadeDeRefrigerante++;
			}
		}

		if (quantidadeDePizza > estoque.getMassaPizza()) {

			throw new RuntimeException("Não temos estoque disponível para a quantidade de pizzas solicitadas!");
		}

		if (quantidadeDeRefrigerante > estoque.getRefrigerante()) {

			throw new RuntimeException("Não temos estoque disponível para a quantidade de refrigerantes solicitados!");
		} else {

			estoque.setMassaPizza(quantidadeDePizza);
			estoque.setRefrigerante(quantidadeDeRefrigerante);
		}

	}

	private void abasteceEstoque() {

		if (estoque.getMassaPizza() <= 3) {
			System.out.println("O Estoque de Pizza está baixo, e foi encomendado mais 10 UND junto ao fornecedor.\n");
			estoque.realizaPedidoPizza();
			System.out.println("O Estoque atual de Pizzas é de " + estoque.getMassaPizza() + " UND.");
		}

		if (estoque.getRefrigerante() <= 3) {
			System.out.println(
					"O Estoque de Refrigerante está baixo, e foi encomendado mais 10 UND junto ao fornecedor.\n");
			estoque.realizaPedidoRefri();
			System.out.println("O Estoque atual de Refrigerantes é de " + estoque.getRefrigerante() + " UND.");
		}

	}

	private void verificaDiaHorario() {
		String dia = DataUtil.pegaDiaDaSemana(new Date());
		String hora = DataUtil.pegaHorario(new Date());
		Integer horaConvertida = Integer.parseInt(hora);

		if (dia.equals("Segunda-feira")) {
			throw new RuntimeException("A Pizzaria está Fechada hoje!");
		}

		if (horaConvertida >= 23 || horaConvertida < 10) {
			throw new RuntimeException("A Pizzaria está Fechada - Horário de Funcionamento: das 10h às 23h. Obrigado!");
		}
	}

	public void registraPedido() {
		verificaDiaHorario();
		rejeitaPizza();
		verificaEstoque();
		informaDadosPedido();
		darBrinde();
		verificaBordaRecheada();
		calculaPedido();
		abasteceEstoque();
		geraRelatorio();

	}

}

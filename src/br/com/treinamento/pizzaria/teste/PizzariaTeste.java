package br.com.treinamento.pizzaria.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.treinamento.pizzaria.Pizzaria;
import br.com.treinamento.pizzaria.modelo.ItemPedido;
import br.com.treinamento.pizzaria.modelo.Pedido;

public class PizzariaTeste {

	public static void main(String[] args) {

		testaRegra1();
		/* O sistema deve registrar os pedidos dos clientes. */

		// testaRegra2();
		/*
		 * Se um cliente comprar a partir de 2 pizzas, ele deve ganhar de brinde 1
		 * refrigerante.
		 */

		// testaRegra3();
		/*
		 * Estamos sem Atum esse mês, então o sistema deve rejeitar pedidos para pizza
		 * de atum.
		 */

		// testaRegra4();
		/*
		 * O Sistema deve gerar um relatório de venda em arquivo .txt com: Número do
		 * Pedido; Data do pedido; Nome do cliente; Telefone do cliente; Ítens do
		 * Pedido; Total de Itens; Valor Total do Pedido;
		 */

		// testaRegra5();
		/*
		 * Se o cliente solicitar borda recheada, o sistema deve somar o valor de R$
		 * 3,00 ao custo final do pedido.
		 */

		// testaRegra6();
		/*
		 * Toda vez que houver um pedido, o sistema deve atualizar os estoques de massas
		 * de Pizzas e Refrigerantes, que iniciam com 10 UND de cada. Se o pedido for
		 * maior do que a quantidade disponível em estoque, o sistema deve rejeitar o
		 * pedido.
		 */

		// testaRegra7();
		/*
		 * Sempre que o estoque de massas e refrigerantes chegar a 3 UND de cada, o
		 * sitema deve solicitar aos fornecedores abastastecer o estoque com mais 10 UND
		 * de cada, e informar o gestor da padaria sobre o estoque atual.
		 */

		// testaRegra8();
		/*
		 * A Pizzaria abre às 10h, fecha às 23h, e fica fechada em dias de Segunda.
		 * Pedidos na segunda e fora de horário devem ser recusados.
		 */

	}

	public static void testaRegra1() {

		ItemPedido pizzaMussarela = new ItemPedido("Pizza Mussarela", ItemPedido.TIPO_PIZZA, 39.9);
		ItemPedido refrigerante = new ItemPedido("Guaraná", ItemPedido.TIPO_REFRIGERANTE, 12.0);

		List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

		itensPedido.add(pizzaMussarela);
		itensPedido.add(refrigerante);

		Pedido pedido = new Pedido(1001, "Alexandre", "11 94025-3220", itensPedido);

		Pizzaria novoPedido = new Pizzaria();
		novoPedido.fazPedido(pedido);
	}

	public static void testaRegra2() {

		ItemPedido pizzaMussarela = new ItemPedido("Pizza Mussarela", ItemPedido.TIPO_PIZZA, 39.9);
		ItemPedido pizzaCalabresa = new ItemPedido("Pizza Calabresa", ItemPedido.TIPO_PIZZA, 48.5);
		ItemPedido refrigerante = new ItemPedido("Guaraná", ItemPedido.TIPO_REFRIGERANTE, 12.0);
		ItemPedido refrigerante2 = new ItemPedido("Guaraná", ItemPedido.TIPO_REFRIGERANTE, 12.0);

		List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

		itensPedido.add(pizzaMussarela);
		itensPedido.add(pizzaCalabresa);
		itensPedido.add(refrigerante);
		itensPedido.add(refrigerante2);

		Pedido pedido = new Pedido(1002, "Cibele", "11 94025-3220", itensPedido);

		Pizzaria novoPedido = new Pizzaria();
		novoPedido.fazPedido(pedido);
	}

	public static void testaRegra3() {

		ItemPedido pizzaAtum = new ItemPedido("Pizza Atum", ItemPedido.TIPO_PIZZA, 39.9);

		List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

		itensPedido.add(pizzaAtum);

		Pedido pedido = new Pedido(1003, "Allan", "11 94025-3220", itensPedido);

		Pizzaria novoPedido = new Pizzaria();

		try {
			novoPedido.fazPedido(pedido);

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testaRegra4() {

		ItemPedido pizzaPortuguesa = new ItemPedido("Pizza Portuguesa", ItemPedido.TIPO_PIZZA, 39.9);
		ItemPedido pizzaQuatroQueijos = new ItemPedido("Pizza Quatro Queijos", ItemPedido.TIPO_PIZZA, 48.5);
		ItemPedido refrigeranteGuarana = new ItemPedido("Guaraná", ItemPedido.TIPO_REFRIGERANTE, 12.0);
		ItemPedido refrigeranteCocaCola = new ItemPedido("CocaCola", ItemPedido.TIPO_REFRIGERANTE, 12.0);

		List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

		itensPedido.add(pizzaPortuguesa);
		itensPedido.add(pizzaQuatroQueijos);
		itensPedido.add(refrigeranteGuarana);
		itensPedido.add(refrigeranteCocaCola);

		Pedido pedido = new Pedido(1004, "Sheila", "11 94025-3220", itensPedido);

		new Pizzaria().fazPedido(pedido);
	}

	public static void testaRegra5() {

		ItemPedido pizzaBaiana = new ItemPedido("Pizza Baiana com Borda Recheada", ItemPedido.TIPO_PIZZA_COM_BORDA,
				39.9);
		ItemPedido refrigerante = new ItemPedido("Fanta Laranja", ItemPedido.TIPO_REFRIGERANTE, 12.0);

		List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

		itensPedido.add(pizzaBaiana);
		itensPedido.add(refrigerante);

		Pedido pedido = new Pedido(1005, "Jaque", "11 94025-3220", itensPedido);

		Pizzaria novoPedido = new Pizzaria();
		novoPedido.fazPedido(pedido);
	}

	public static void testaRegra6() {

		ItemPedido pizzaPortuguesa = new ItemPedido("Pizza Mussarela", ItemPedido.TIPO_PIZZA, 39.9);
		ItemPedido pizzaQuatroQueijos = new ItemPedido("Pizza Calabresa", ItemPedido.TIPO_PIZZA, 48.5);
		ItemPedido pizzaFeijao = new ItemPedido("Pizza Feijão", ItemPedido.TIPO_PIZZA, 39.9);
		ItemPedido pizzaBacon = new ItemPedido("Pizza Bacon", ItemPedido.TIPO_PIZZA, 48.5);
		ItemPedido pizzaVerdura = new ItemPedido("Pizza Verdura", ItemPedido.TIPO_PIZZA, 39.9);
		ItemPedido pizzaPalmito = new ItemPedido("Pizza Palmito", ItemPedido.TIPO_PIZZA, 48.5);
		ItemPedido pizzaRucula = new ItemPedido("Pizza Rúcula", ItemPedido.TIPO_PIZZA, 39.9);
		ItemPedido pizzaDaCasa = new ItemPedido("Pizza da Casa", ItemPedido.TIPO_PIZZA, 48.5);
		ItemPedido pizzaBanana = new ItemPedido("Pizza Banana", ItemPedido.TIPO_PIZZA, 48.5);
		ItemPedido pizzaChocolate = new ItemPedido("Pizza Chocolate", ItemPedido.TIPO_PIZZA, 39.9);
		ItemPedido pizzaAbobrinha = new ItemPedido("Pizza Abobrinha", ItemPedido.TIPO_PIZZA, 48.5);

		ItemPedido refrigeranteGuarana = new ItemPedido("Guaraná", ItemPedido.TIPO_REFRIGERANTE, 12.0);
		ItemPedido refrigeranteCocaCola = new ItemPedido("CocaCola", ItemPedido.TIPO_REFRIGERANTE, 12.0);

		List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

		itensPedido.add(pizzaPortuguesa);
		itensPedido.add(pizzaQuatroQueijos);
		itensPedido.add(pizzaFeijao);
		itensPedido.add(pizzaBacon);
		itensPedido.add(pizzaVerdura);
		itensPedido.add(pizzaPalmito);
		itensPedido.add(pizzaRucula);
		itensPedido.add(pizzaDaCasa);
		itensPedido.add(pizzaBanana);
		itensPedido.add(pizzaChocolate);
		itensPedido.add(pizzaAbobrinha);

		itensPedido.add(refrigeranteGuarana);
		itensPedido.add(refrigeranteCocaCola);

		Pedido pedido = new Pedido(1006, "Paulinho", "11 94025-3220", itensPedido);

		try {

			new Pizzaria().fazPedido(pedido);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

	public static void testaRegra7() {

		ItemPedido pizzaPortuguesa = new ItemPedido("Pizza Mussarela", ItemPedido.TIPO_PIZZA, 39.9);
		ItemPedido pizzaQuatroQueijos = new ItemPedido("Pizza Calabresa", ItemPedido.TIPO_PIZZA, 48.5);
		ItemPedido pizzaFeijao = new ItemPedido("Pizza Feijão", ItemPedido.TIPO_PIZZA, 39.9);
		ItemPedido pizzaBacon = new ItemPedido("Pizza Bacon", ItemPedido.TIPO_PIZZA, 48.5);
		ItemPedido pizzaVerdura = new ItemPedido("Pizza Verdura", ItemPedido.TIPO_PIZZA, 39.9);
		ItemPedido pizzaPalmito = new ItemPedido("Pizza Palmito", ItemPedido.TIPO_PIZZA, 48.5);
		ItemPedido pizzaRucula = new ItemPedido("Pizza Rúcula", ItemPedido.TIPO_PIZZA, 39.9);
		ItemPedido pizzaDaCasa = new ItemPedido("Pizza da Casa", ItemPedido.TIPO_PIZZA, 48.5);

		ItemPedido refrigeranteGuarana = new ItemPedido("Guaraná", ItemPedido.TIPO_REFRIGERANTE, 12.0);
		ItemPedido refrigeranteCocaCola = new ItemPedido("CocaCola", ItemPedido.TIPO_REFRIGERANTE, 12.0);
		ItemPedido refrigeranteFanta = new ItemPedido("Fanta", ItemPedido.TIPO_REFRIGERANTE, 12.0);
		ItemPedido refrigeranteDolly = new ItemPedido("Dolly", ItemPedido.TIPO_REFRIGERANTE, 12.0);
		ItemPedido refrigerantePepsi = new ItemPedido("Pepsi", ItemPedido.TIPO_REFRIGERANTE, 12.0);
		ItemPedido refrigeranteCoca = new ItemPedido("Coca", ItemPedido.TIPO_REFRIGERANTE, 12.0);
		ItemPedido refrigerantePet = new ItemPedido("Pet", ItemPedido.TIPO_REFRIGERANTE, 12.0);

		List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

		itensPedido.add(pizzaPortuguesa);
		itensPedido.add(pizzaQuatroQueijos);
		itensPedido.add(pizzaFeijao);
		itensPedido.add(pizzaBacon);
		itensPedido.add(pizzaVerdura);
		itensPedido.add(pizzaPalmito);
		itensPedido.add(pizzaRucula);
		itensPedido.add(pizzaDaCasa);

		itensPedido.add(refrigeranteGuarana);
		itensPedido.add(refrigeranteCocaCola);
		itensPedido.add(refrigeranteFanta);
		itensPedido.add(refrigeranteDolly);
		itensPedido.add(refrigerantePepsi);
		itensPedido.add(refrigeranteCoca);
		itensPedido.add(refrigerantePet);

		Pedido pedido = new Pedido(1007, "Antonia", "11 94025-3220", itensPedido);

		new Pizzaria().fazPedido(pedido);

	}

	public static void testaRegra8() {

		ItemPedido pizzaMussarela = new ItemPedido("Pizza Mussarela", ItemPedido.TIPO_PIZZA, 39.9);
		ItemPedido refrigerante = new ItemPedido("Guaraná", ItemPedido.TIPO_REFRIGERANTE, 12.0);

		List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

		itensPedido.add(pizzaMussarela);
		itensPedido.add(refrigerante);

		Pedido pedido = new Pedido(1008, "Manoel", "11 94025-3220", itensPedido);

		Pizzaria novoPedido = new Pizzaria();

		try {
			novoPedido.fazPedido(pedido);

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

}

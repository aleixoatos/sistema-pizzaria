package br.com.treinamento.pizzaria.modelo;

public class Estoque {

	private Integer massaPizza;
	private Integer refrigerante;

	public Estoque(Integer massaPizza, Integer refrigerante) {
		this.massaPizza = massaPizza;
		this.refrigerante = refrigerante;
	}

	public Integer getMassaPizza() {
		return massaPizza;
	}

	public void setMassaPizza(Integer massaPizza) {
		this.massaPizza -= massaPizza;
	}

	public Integer getRefrigerante() {
		return refrigerante;
	}

	public void setRefrigerante(Integer refrigerante) {
		this.refrigerante -= refrigerante;
	}

	public void realizaPedidoPizza() {
		this.massaPizza += 10;
	}

	public void realizaPedidoRefri() {
		this.refrigerante += 10;
	}

}

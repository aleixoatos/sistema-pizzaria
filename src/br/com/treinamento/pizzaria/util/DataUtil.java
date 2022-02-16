package br.com.treinamento.pizzaria.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	public static String formataDataPadraoBrasil(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String dataStf = sdf.format(data);

		return dataStf;

	}

	public static String pegaDiaDaSemana(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");

		String diaDaSemana = sdf.format(data);

		return diaDaSemana;

	}

	public static String pegaHorario(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH");

		String horaDoPedido = sdf.format(data);

		return horaDoPedido;

	}

}
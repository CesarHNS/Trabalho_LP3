package executar;

import java.util.HashMap;

import Relatorios.Relatorio;

public class Execute {

	private static HashMap fil;
	
	public static void main(String[] args) {
		fil = new HashMap<>();
		Relatorio.callRelatorio("Clientes", "Relatório de Clientes", fil);
	}
	
}

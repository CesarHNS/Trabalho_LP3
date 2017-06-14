package Relatorios;

import java.awt.Frame;
import java.sql.Connection;
import java.util.HashMap;

import dal.ModuloConexao;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {

	private static String path;

	public static void callRelatorio(String nomeRel, String title, HashMap<String,Object> filtro){
		
		try {
			
			Connection conexao = ModuloConexao.conector();
			path = "/Users/Projeto/Documents/GitHub/Trabalho_LP3/Oficina_Mecânica/src/Relatorios/"+nomeRel+".jrxml";
			JasperPrint print = JasperFillManager.fillReport(path, filtro,conexao);
			JasperViewer viewr = new JasperViewer(print,false);
			viewr.setVisible(true);
			viewr.setExtendedState(Frame.MAXIMIZED_BOTH);
			viewr.setTitle(title);

			
		} catch (Exception e) {
			
		}
		
	}

}

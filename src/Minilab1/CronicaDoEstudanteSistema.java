package Minilab1;

import java.util.ArrayList;

public class CronicaDoEstudanteSistema {
	private int iCro;
	private ArrayList<Cronica> cronicas;
	
	
	public CronicaDoEstudanteSistema() {
		this.cronicas = new ArrayList<>();
		this.iCro = 0;
	}
	
	public void cadastraCronica(String titulo,String texto,String data, String autor) {
		Cronica cronica = new Cronica(titulo, texto, data, autor);
		this.cronicas.add(cronica);
		this.iCro++;
	}
	public String listarCronicas() {
		StringBuilder out = new StringBuilder();
		for(int i =0; i < cronicas.size(); i++) {
			out.append("Cronica #").append(i+1).append("\n");
			out.append(cronicas.get(i).toString()).append("\n");
		}
		return out.toString();
	}
	public String lerCronica(int i) {
		if(i < 0 || i > cronicas.size()){
			throw new IllegalArgumentException("Índice de crônica inválido!");
		}
		cronicas.get(i).addQLeitura();
		return cronicas.get(i).toString();
	}
	public String exibirCronicaMaisLida() {
		if(cronicas.isEmpty()) {
			throw new IllegalArgumentException("Nenhuma crônica cadastrada para exibir.");
		}
		int iMaisLida = 0;
		for(int i = 0; i < cronicas.size();i++) {
			if(cronicas.get(i).getQleitura(i) > cronicas.get(iMaisLida).getQleitura(i)) {
				iMaisLida = i;
			}
		}
		return cronicas.get(iMaisLida).formataTitulo();
	}
}

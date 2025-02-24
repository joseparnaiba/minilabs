package Simulado1;

import java.util.ArrayList;

public class CarneLeopardoSistema {
	private ArrayList<Contribuinte> contribuintes;
	private ArrayList<Tributo> tributos;
	
	public CarneLeopardoSistema() {
		contribuintes = new ArrayList<>();
		tributos = new ArrayList<>();
	}
	public String cadastraContribuinte(String cpf,String nome, String contato) {
		if(contribuintes.size()< 100 ) {
			for(Contribuinte contribuinte: contribuintes) {
				if(contribuinte.getCpf().equals(cpf)) {
					throw new IllegalArgumentException("Contribuinte já cadastrado!");
				}
			}
			Contribuinte novoContribuinte = new Contribuinte(cpf,nome,contato);
			contribuintes.add(novoContribuinte);
			return cpf;
			} else {
				return "Limite atingido";
			}
	}
}

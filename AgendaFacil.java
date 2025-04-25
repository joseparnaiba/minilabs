package prova2;

import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.*;

public class AgendaFacil {
	private final HashMap<String,Estudante> estudantes;
	private final Map< Integer, Evento> eventos; 
	private int nextIdEvento = 1;
	
	public AgendaFacil() {
		estudantes = new HashMap<>();
		eventos = new HashMap<>();
	}

	public boolean cadastrarEstudante(String nome, String email) {
		if(estudantes.containsKey(email)){
			throw new IllegalArgumentException("Usuario já cadastrado! ");
		}
		estudantes.put(email,new Estudante(nome,email));
		return true;
	}
	public String exibirEstudante(String email) {
		Estudante estudante = estudantes.get(email);
		if(estudante == null) {
			return null;
		}
		 return String.format("Nome: %s, quantidade de eventos: %e, quantidade de pontos: %f",estudantes.get(email).getNome(),estudantes.get(email).getQpont(),estudantes.get(email).getQpont());
		}
	/*
		//Estudante estudante = estudantes.get(email);
		for(Estudante estudante: estudantes.values()) {
			estudante.toString();
			
		}
	}
	
	public int cadastrarPalestra(String titulo, String descricao, String data, int
maxParticipantes) {
		
	}

	public int cadastrarWorkshop(String titulo, String descricao, String data, int
maxParticipantes, int duracao) {
		
	}

	public int cadastrarOficinaAprendizagem(String titulo, String descricao, String
data, int maxParticipantes, int duracao, boolean certificacao) {
		
	}

	public boolean inscreverParticipanteEmEvento(String emailParticipante, int
idEvento) {
		
	}

	public String exibirDetalhesEvento(int idEvento) {
		
	}
	*/
}

package prova2resp;

import java.util.ArrayList;
import java.util.List;

public abstract class Eventos {
	private String titulo;
	private String descricao;
	private String data;
	private int maxParticipantes;
	private List<Estudante> participantes;
	
	public Eventos(String titulo, String descricao, String data, int maxParticipantes) {
		this.data = data;
		this.descricao = descricao;
		this.titulo = titulo;
		this.maxParticipantes = maxParticipantes;
		this.participantes = new ArrayList<>();
	}
	
	public List<Estudante> getParticipantes() {
        return participantes;
    }
	
	 public void addParticipante(Estudante estudante) {
	        participantes.add(estudante);
	    }
	 public abstract int calcularPontuacao();
	 
	 public int getMaxParticipantes() {
	        return maxParticipantes;
	    }

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getData() {
		return data;
	}

	
}

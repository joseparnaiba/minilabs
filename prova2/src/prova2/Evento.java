package prova2;

import java.util.HashSet;

public abstract class Evento {

	private String título;
	private String descrição;
	private String data;
	private int quantidademaxp;
	private HashSet<Estudante> participantes;
	private int id;
	
	
	public Evento(int id ,String ti,String d,String dat,int quant) {
		this.título = ti;
		this.descrição = d;
		this.quantidademaxp = quant;
		this.id = id;
		this.participantes = new HashSet<>();
	}


	public String getTítulo() {
		return título;
	}


	public String getDescrição() {
		return descrição;
	}


	public String getData() {
		return data;
	}


	public int getQuantidademaxp() {
		return quantidademaxp;
	}


	public HashSet<Estudante> getParticipantes() {
		return participantes;
	}


	public int getId() {
		return id;
	}
	public int calcularPontos() {
		return 0;
	}
	
}

package Simulado1;

import java.util.Objects;

public class Contribuinte {
	private String nome;
	private String cpf;
	private String contato;
	
	public Contribuinte(String n,String c,String con) {
		this.contato = con;
		this.cpf = c;
		this.nome = n;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getContato() {
		return contato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || (getClass() != obj.getClass()))
			return false;
		Contribuinte other = (Contribuinte) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
}

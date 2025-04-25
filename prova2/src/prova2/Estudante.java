package prova2;

import java.util.Objects;

public class Estudante implements Comparable<Estudante>{
	private String nome;
	private String email;
	private int qevent;
	private int qpont;

	
	public Estudante(String nome,String email){
		this.nome = nome;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Estudante [nome=" + nome + ", qevent=" + qevent + ", qpont=" + qpont + "]";
	}
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public int getQevent() {
		return qevent;
	}

	public int getQpont() {
		return qpont;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudante other = (Estudante) obj;
		return Objects.equals(email, other.email);
	}

	@Override
	public int compareTo(Estudante o) {
		
		return 0;
	}
	
}

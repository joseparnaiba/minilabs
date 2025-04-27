package prova2resp;

import java.util.Objects;

public class Estudante {
    private String nome;
    private String email;
    private int eventosParticipados;
    private int qpontos;

    public Estudante(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.eventosParticipados = 0;
        this.qpontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getEventosParticipados() {
        return eventosParticipados;
    }

    public int getQpontos() {
        return qpontos;
    }

    public void incrementarPontuacao(int pontos) {
        this.qpontos += pontos;
    }

    public void incrementarEventosParticipados() {
        this.eventosParticipados++;
    }

    @Override
    public String toString() {
        return nome + " - Eventos: " + eventosParticipados + ", Pontos: " + qpontos;
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
}

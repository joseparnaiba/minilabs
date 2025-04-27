package prova2resp;

public class Palestra extends Eventos{
	
	
	public Palestra(String titulo, String descricao, String data, int maxParticipantes) {
			super(titulo,descricao,data,maxParticipantes);
	}
	@Override
    public int calcularPontuacao() {
        return 2; // Palestra sempre dá 2 pontos
    }
	
	
	
}

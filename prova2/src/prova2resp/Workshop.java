package prova2resp;

public class Workshop extends Eventos{
	
	private int duracao;
	
	public Workshop(String titulo, String descricao, String data, int
			maxParticipantes, int duracao){
		super(titulo,descricao,data,maxParticipantes);
		this.duracao = duracao;
		
	}
	 @Override
	    public int calcularPontuacao() {
	        return duracao; // Workshop dá a quantidade de pontos igual à duração
	    }
	 public int getDuracao() {
	        return duracao;
	    }
}

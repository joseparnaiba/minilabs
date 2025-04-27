package prova2resp;

public class OficinaAprendizagem extends Eventos  implements DuracaoHoras , Certificavel {
	
	private int duracao;
	private boolean certificacao;
	private int duracaoHoras;
	
	
	public OficinaAprendizagem(String titulo, String descricao, String
	data, int maxParticipantes, int duracao, boolean certificacao) {
		super(titulo,descricao,data,maxParticipantes);
		this.duracao = duracao;
		this.certificacao = certificacao;
	}
	@Override
    public int calcularPontuacao() {
        int pontos = duracao;
        if (certificacao) {
            pontos += 10; // +10 pontos se tiver certificação
        }
        return pontos;
    }

	 @Override
	    public int getDuracao() {
	        return duracaoHoras;
	    }

	    @Override
	    public boolean temCertificado() {
	        return certificacao;
	    }
}

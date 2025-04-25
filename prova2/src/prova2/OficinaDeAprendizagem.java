package prova2;

public class OficinaDeAprendizagem extends Evento {
	private int duracao;
	private boolean certificado;
	
	public OficinaDeAprendizagem (int id ,String ti,String d,String dat,int quant) {
		super(id,ti,d,dat,quant);
	}
	@Override
	public int calcularPontos() {
		if(certificado == true) {
			return duracao + 10;
		}
		return duracao;
	}
	
}

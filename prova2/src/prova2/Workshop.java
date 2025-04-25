package prova2;

public class Workshop extends Evento{
	private int duracao;
	
	public Workshop(int id ,String ti,String d,String dat,int quant) {
		super(id,ti,d,dat,quant);
	}
	@Override
	public int calcularPontos() {
		return duracao;
	}
	public int duracao() {
		return duracao;
	}
	
}

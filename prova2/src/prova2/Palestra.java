package prova2;

public class Palestra extends Evento  {
	public Palestra (int id ,String ti,String d,String dat,int quant) {
		super(id,ti,d,dat,quant);
	}
	@Override
	public int calcularPontos() {
		return 2;
	}
}

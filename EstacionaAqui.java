package Miniab2;

import java.util.ArrayList;

public class EstacionaAqui {
	private ArrayList<Vaga> vagas;
	private Comentario[] Comentario;
	private final int capacidadeMaxima = 10;
	
	public EstacionaAqui() {
		vagas = new ArrayList<>();
	}
	public int adicionaVaga(String end,String linkmp,double ar) {
		int numeroVaga = vagas.size();
		Vaga novaVaga = new Vaga(end,numeroVaga,linkmp,ar);
		vagas.add(novaVaga);
		return numeroVaga;
	}
	public int adicionaVaga(String end,double ar) throws IllegalArgumentException {
		//if()
		int numeroVaga = vagas.size();
		Vaga novaVaga = new Vaga(end,numeroVaga,ar);
		vagas.add(novaVaga);
		return numeroVaga;
	}
	public void mudarStatusVaga(){
		
	}
	public void  simulaPreco() {
		
	}
	//public String listarVagas() {
		
	//}
	//public comentar() {
		
	//}
	//public  listarComentarios() {
		
	//}
	
}

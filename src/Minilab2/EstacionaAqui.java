package Minilab2;

import java.util.ArrayList;

public class EstacionaAqui {
    private ArrayList<Vaga> vagas;
    private ArrayList<Comentario> comentarios;
    private final int capacidadeMaxima = 100;
    private final int capacdadeMaxComentario = 5;
    

    public EstacionaAqui() {
        vagas = new ArrayList<>();
    }
    public int adicionaVaga(String end,String linkmp,double ar) {
        if(vagas.size() >= capacidadeMaxima){
        	 throw new IllegalArgumentException("Capacidade máxima atingida.");
        	}
    	int numeroVaga = vagas.size();
        Vaga novaVaga = new Vaga(end,numeroVaga,linkmp,ar);
        vagas.add(novaVaga);
        return numeroVaga;
    }
    public int adicionaVaga(String end,double ar){
    	return adicionaVaga(end, "https://", ar);
    }
    public void mudarStatusVaga(int numeroVaga){
    	 if (numeroVaga < 0 || numeroVaga >= vagas.size()) {
             throw new IllegalArgumentException("Vaga inexistente.");
         }
         vagas.get(numeroVaga).mudarStatus();
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

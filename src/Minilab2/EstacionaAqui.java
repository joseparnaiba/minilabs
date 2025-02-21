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
    public int  simulaPreco(int numeroVaga,int qtdHoras) {
    	 if (numeroVaga < 0 || numeroVaga >= vagas.size()) {
             throw new IllegalArgumentException("Vaga inexistente.");
         }
         return vagas.get(numeroVaga).calculaValor(qtdHoras);
     }
    public String[] listarVagas() {
        String[] resultado = new String[vagas.size()];
        for (int i = 0; i < vagas.size(); i++) {
            resultado[i] = vagas.get(i).toString();
        }
        return resultado;
    }
    
    public void comentar(String texto, String autor) {
        if (comentarios.size() == MAX_COMENTARIOS) {
            comentarios.remove(0);
        }
        comentarios.add(new Comentario(texto, autor));
    }
    
    public String[] listarComentarios() {
        return comentarios.stream().map(Comentario::toString).toArray(String[]::new);
    }
}

}

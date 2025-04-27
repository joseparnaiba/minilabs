package prova2resp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgendaFacil {
	private Map<String,Estudante> estudantes;
	private Map<Integer,Eventos> eventos;
	private int idContador;
	
	public AgendaFacil() {
		estudantes = new HashMap<>();
		eventos = new HashMap<>();
		this.idContador = 1;
	}

	public boolean cadastrarEstudante(String nome, String email) {
		if(!estudantes.containsKey(email)){
			Estudante novoEstudante = new Estudante(email,nome);
			estudantes.put(email, novoEstudante);
			return true;
		}
		throw new IllegalArgumentException("Estudante já cadastrado!");
	}
	/*
	 * public boolean cadastrarEstudante(String nome, String email) {
        if (estudantes.containsKey(email)) {
            return false; // Já existe um estudante com esse email
        }
        estudantes.put(email, new Estudante(nome, email));
        return true;
    }

	 */
	
	public String exibirEstudante(String email) {
		if(estudantes.containsKey(email)) {
			return estudantes.get(email).toString();
		}
		throw new IllegalArgumentException("Estudante não encontrado!");
	}
	/*
	 *  public String exibirEstudante(String email) {
        Estudante estudante = estudantes.get(email);
        if (estudante == null) {
            return "Estudante não encontrado.";
        }
        return estudante.toString();
    }
	 */
	
	public String[] listarEstudantes() {
		List<Estudante> listaEstudantes = new ArrayList<>(estudantes.values());
		listaEstudantes.sort(Comparator.comparingInt(Estudante::getQpontos).reversed());
		
		String[] resultado = new String[listaEstudantes.size()];
		for(int i=0;i < listaEstudantes.size();i++) {
			resultado[i] = listaEstudantes.get(i).getNome();
		}
		return resultado;
	}
	
	public int cadastrarPalestra(String titulo, String descricao, String data, int maxParticipantes) {
		Palestra palestra = new Palestra(titulo,descricao,data,maxParticipantes);
		int id = idContador++;
		eventos.put(id, palestra);
		return id;
	}
			
	public int cadastrarWorkshop(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		Workshop workshp = new Workshop(titulo,descricao,data,maxParticipantes,duracao);
		int id = idContador++;
		eventos.put(id, workshp);
		return id;
	}
					
	public int cadastrarOficinaAprendizagem(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean certificacao) {
		OficinaAprendizagem oficina = new OficinaAprendizagem(titulo,descricao,data,maxParticipantes,duracao,certificacao);
		int id = idContador++;
		eventos.put(id, oficina);
		return id;
	}
			
	public boolean inscreverParticipanteEmEvento(String emailParticipante, int idEvento){
		Estudante estudante = estudantes.get(emailParticipante);
		Eventos evento = eventos.get(idEvento);
		if(estudante == null || evento == null) {
			throw new IllegalArgumentException("Estudante ou evento não encontrado.");
		}
		if (evento.getParticipantes().contains(estudante)) {
	        throw new IllegalArgumentException("Estudante já inscrito neste evento.");
	    }
	    
	    if (evento.getParticipantes().size() >= evento.getMaxParticipantes()) {
	        throw new IllegalArgumentException("Evento já atingiu o número máximo de participantes.");
	    }
	    
	    evento.addParticipante(estudante);
	    estudante.incrementarPontuacao(evento.calcularPontuacao());
	    estudante.incrementarEventosParticipados();
	    
	    return true;
	}
	
	 public String exibirDetalhesEvento(int idEvento) {
		 Eventos evento = eventos.get(idEvento);
		    
		    if (evento == null) {
		        throw new IllegalArgumentException("Evento não encontrado.");
		    }
		    StringBuilder sb = new StringBuilder();
		    sb.append("Título: ").append(evento.getTitulo()).append("\n");
		    sb.append("Descrição: ").append(evento.getDescricao()).append("\n");
		    sb.append("Data: ").append(evento.getData()).append("\n");
		    sb.append("Pontuação: ").append(evento.calcularPontuacao()).append("\n");

		    if (evento instanceof Workshop) {
		        Workshop workshop = (Workshop) evento;
		        sb.append("Duração: ").append(workshop.getDuracao()).append(" horas\n");
		    } else if (evento instanceof OficinaAprendizagem) {
		        OficinaAprendizagem oficina = (OficinaAprendizagem) evento;
		        sb.append("Duração: ").append(oficina.getDuracao()).append(" horas\n");
		        sb.append("Certificação: ").append(oficina.temCertificado() ? "Sim" : "Não").append("\n");
		    }
		    
		    sb.append("Participantes:\n");
		    for (Estudante estudante : evento.getParticipantes()) {
		        sb.append("- ").append(estudante.getNome()).append("\n");
		    }
		    
		    return sb.toString().trim();
	 }
	 
}

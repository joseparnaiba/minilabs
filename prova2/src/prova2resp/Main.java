package prova2resp;

public class Main {

	public static void main(String[] args) {
		AgendaFacil agenda = new AgendaFacil();

        // Cadastra estudantes
        agenda.cadastrarEstudante("Lucas", "lucas@email.com");
        agenda.cadastrarEstudante("Julia", "julia@email.com");

        // Cadastra eventos
        int idPalestra = agenda.cadastrarPalestra("Palestra de Inovação", "Tecnologia no futuro", "01/06/2025", 100);
        int idWorkshop = agenda.cadastrarWorkshop("Workshop de IA", "Introdução à Inteligência Artificial", "05/06/2025", 50, 6);
        int idOficina = agenda.cadastrarOficinaAprendizagem("Oficina de Robótica", "Montagem de robôs", "10/06/2025", 30, 5, true);

        // Inscreve estudantes
        agenda.inscreverParticipanteEmEvento("lucas@email.com", idPalestra);
        agenda.inscreverParticipanteEmEvento("lucas@email.com", idWorkshop);
        agenda.inscreverParticipanteEmEvento("julia@email.com", idOficina);

        // Exibe detalhes dos eventos
        System.out.println("\nDetalhes do Evento - Palestra:");
        System.out.println(agenda.exibirDetalhesEvento(idPalestra));

        System.out.println("\nDetalhes do Evento - Workshop:");
        System.out.println(agenda.exibirDetalhesEvento(idWorkshop));

        System.out.println("\nDetalhes do Evento - Oficina de Aprendizagem:");
        System.out.println(agenda.exibirDetalhesEvento(idOficina));

        // Lista ranking dos estudantes
        System.out.println("\nRanking dos Estudantes:");
        String[] ranking = agenda.listarEstudantes();
        for (String nome : ranking) {
            System.out.println(nome);
        }
    }
}

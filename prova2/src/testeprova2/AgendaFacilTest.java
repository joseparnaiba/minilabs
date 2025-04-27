package testeprova2;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import prova2resp.AgendaFacil;
import prova2resp.Estudante;

public class AgendaFacilTest {

	private AgendaFacil agenda;

	@BeforeEach
	void setUp() {
		agenda = new AgendaFacil();
	}

	@Test
	void testPontuacaoEstudantePalestra() {
		agenda.cadastrarEstudante("João", "joao@email.com");
		int idPalestra = agenda.cadastrarPalestra("Palestra Java", "Aprenda Java", "10/05/2025", 100);

		agenda.inscreverParticipanteEmEvento("joao@email.com", idPalestra);

		Estudante joao = getEstudanteByEmail("joao@email.com");
		assertEquals(2, joao.getQpontos()); // Palestra dá 2 pontos
	}

	@Test
	void testPontuacaoEstudanteWorkshop() {
		agenda.cadastrarEstudante("Maria", "maria@email.com");
		int idWorkshop = agenda.cadastrarWorkshop("Workshop Spring", "Aprenda Spring Boot", "12/05/2025", 50, 5);

		agenda.inscreverParticipanteEmEvento("maria@email.com", idWorkshop);

		Estudante maria = getEstudanteByEmail("maria@email.com");
		assertEquals(5, maria.getQpontos()); // Workshop dá pontos iguais à duração
	}

	@Test
	void testPontuacaoEstudanteOficinaComCertificacao() {
		agenda.cadastrarEstudante("Pedro", "pedro@email.com");
		int idOficina = agenda.cadastrarOficinaAprendizagem("Oficina Kotlin", "Aprenda Kotlin", "15/05/2025", 30, 4, true);

		agenda.inscreverParticipanteEmEvento("pedro@email.com", idOficina);

		Estudante pedro = getEstudanteByEmail("pedro@email.com");
		assertEquals(14, pedro.getQpontos()); // 4 + 10 = 14 pontos
	}

	@Test
	void testRankingEstudantesPorPontuacao() {
		agenda.cadastrarEstudante("Ana", "ana@email.com");
		agenda.cadastrarEstudante("Bruno", "bruno@email.com");

		int idPalestra = agenda.cadastrarPalestra("Palestra Redes", "Redes de Computadores", "20/05/2025", 50);
    	int idWorkshop = agenda.cadastrarWorkshop("Workshop Docker", "Containers na prática", "21/05/2025", 50, 3);

    	agenda.inscreverParticipanteEmEvento("ana@email.com", idWorkshop);  // Ana ganha 3 pontos
    	agenda.inscreverParticipanteEmEvento("bruno@email.com", idPalestra); // Bruno ganha 2 pontos

    	String[] ranking = agenda.listarEstudantes();
    	assertEquals("Ana", ranking[0]); // Ana tem mais pontos
    	assertEquals("Bruno", ranking[1]);
	}

	private Estudante getEstudanteByEmail(String email) {
    // Gambiarra só pra pegar o estudante sem alterar muito o AgendaFacil
		try {
        java.lang.reflect.Field field = AgendaFacil.class.getDeclaredField("estudantes");
        field.setAccessible(true);
        @SuppressWarnings("unchecked")
        java.util.Map<String, Estudante> estudantes = (java.util.Map<String, Estudante>) field.get(agenda);
        return estudantes.get(email);
		} catch (Exception e) {
        throw new RuntimeException(e);
		}
	}

}

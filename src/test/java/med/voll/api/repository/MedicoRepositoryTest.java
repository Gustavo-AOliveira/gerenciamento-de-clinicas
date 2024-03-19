package med.voll.api.repository;

import med.voll.api.domain.Consulta.Consulta;
import med.voll.api.domain.Endereco.DadosEndereco;
import med.voll.api.domain.Medico.DadosCadastroMedico;
import med.voll.api.domain.Medico.Especialidade;
import med.voll.api.domain.Medico.Medico;
import med.voll.api.domain.Paciente.DadosCadastroPaciente;
import med.voll.api.domain.Paciente.Paciente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MedicoRepositoryTest {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private TestEntityManager em;
    @Test
    @DisplayName("Deveria devolver null quando único médico cadastrado não está disponível na data")
    void randomMedicoDisponivelCenario1() {
        // Parte 1: Cadastra as informações necessárias pra chamar o método // Given
        var proximaSegundaAs10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10,0);
        var medico = cadastrarMedico("Medico", "medico@gmail.com", "123456", Especialidade.CARDIOLOGIA);
        var paciente = cadastrarPaciente("Paciente", "paciente@gmail.com", "00000000000");
        cadastrarConsulta(medico, paciente, proximaSegundaAs10);

        //A chamada do método// When
        var medicoLivre = medicoRepository.randomMedicoDisponivel(Especialidade.CARDIOLOGIA, proximaSegundaAs10);

        //A verificação// Assert
        assertThat(medicoLivre).isNull();
    }

    @Test
    @DisplayName("Deveria devolver o médico quando ele estiver disponível")
    void randomMedicoDisponivelCenario2() {
        var proximaSegundaAs10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10,0);

        var medico = cadastrarMedico("Medico", "medico@gmail.com", "123456", Especialidade.CARDIOLOGIA);

        var medicoLivre = medicoRepository.randomMedicoDisponivel(Especialidade.CARDIOLOGIA, proximaSegundaAs10);
        assertThat(medicoLivre).isEqualTo(medico);
    }




    private void cadastrarConsulta(Medico medico, Paciente paciente, LocalDateTime data) {
        em.persist(new Consulta(null, medico, paciente, data));
    }

    private Medico cadastrarMedico(String nome, String email, String crm, Especialidade especialidade) {
        var medico = new Medico(dadosMedico(nome, email, crm, especialidade));
        em.persist(medico);
        return medico;
    }

    private Paciente cadastrarPaciente(String nome, String email, String cpf) {
        var paciente = new Paciente(dadosPaciente(nome, email, cpf));
        em.persist(paciente);
        return paciente;
    }

    private DadosCadastroMedico dadosMedico(String nome, String email, String crm, Especialidade especialidade) {
        return new DadosCadastroMedico(
                nome,
                email,
                "61999999999",
                crm,
                especialidade,
                dadosEndereco()
        );
    }

    private DadosCadastroPaciente dadosPaciente(String nome, String email, String cpf) {
        return new DadosCadastroPaciente(
                nome,
                email,
                "61999999999",
                cpf,
                dadosEndereco()
        );
    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "rua xpto",
                "bairro",
                "00000000",
                "Brasilia",
                "DF",
                null,
                null
        );
    }
}
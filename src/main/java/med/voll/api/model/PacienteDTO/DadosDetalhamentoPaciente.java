package med.voll.api.model.PacienteDTO;

import med.voll.api.model.domain.Endereco;
import med.voll.api.model.domain.Paciente;

public record DadosDetalhamentoPaciente(long id, String nome, String email, String telefone, String cpf, Endereco endereco) {

    public DadosDetalhamentoPaciente (Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}

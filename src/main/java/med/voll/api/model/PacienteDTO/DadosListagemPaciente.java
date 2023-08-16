package med.voll.api.model.PacienteDTO;

import med.voll.api.model.domain.Paciente;

public record DadosListagemPaciente(long id, String nome, String email, String cpf) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(),paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}

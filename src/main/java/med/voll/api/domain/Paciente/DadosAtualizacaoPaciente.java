package med.voll.api.domain.Paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.Endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}

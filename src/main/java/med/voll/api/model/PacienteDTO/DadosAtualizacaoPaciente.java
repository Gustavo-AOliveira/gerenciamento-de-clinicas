package med.voll.api.model.PacienteDTO;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.EnderecoDTO.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}

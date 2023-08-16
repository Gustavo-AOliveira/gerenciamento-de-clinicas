package med.voll.api.model.MedicoDTO;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.EnderecoDTO.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
)
{
}

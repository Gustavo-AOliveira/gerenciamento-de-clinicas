package med.voll.api.model.MedicoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.EnderecoDTO.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @Email
        @NotBlank
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull @Valid
        DadosEndereco endereco
) {
}

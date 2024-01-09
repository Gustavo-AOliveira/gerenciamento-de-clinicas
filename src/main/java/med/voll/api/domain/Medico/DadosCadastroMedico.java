package med.voll.api.domain.Medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.Endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank(message = "O nome não pode estar em branco.")
        String nome,
        @Email(message = "O email deve ser válido.")
        @NotBlank(message = "O email não pode estar em branco.")
        String email,
        @NotBlank(message = "O telefone não pode estar em branco.")
        @Pattern(regexp = "\\d{11}", message = "O telefone deve conter 11 dígitos numéricos.")
        String telefone,
        @NotBlank(message = "O CRM não pode estar em branco.")
        @Pattern(regexp = "\\d{4,6}", message = "O CRM deve conter entre 4 e 6 dígitos numéricos.")
        String crm,
        @NotNull(message = "A especialidade não pode ser nula.")
        Especialidade especialidade,
        @NotNull(message = "O endereço não pode ser nulo.")
        @Valid
        DadosEndereco endereco
) {
}

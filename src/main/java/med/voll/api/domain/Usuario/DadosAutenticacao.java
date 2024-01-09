package med.voll.api.domain.Usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(
        @NotBlank(message = "O usuário não pode estar em branco.")
        String login,
        @NotBlank(message = "A senha não pode estar em branco.")
        String senha
) {
}

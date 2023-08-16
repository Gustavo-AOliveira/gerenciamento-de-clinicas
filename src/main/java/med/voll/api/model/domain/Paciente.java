package med.voll.api.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.PacienteDTO.DadosAtualizacaoPaciente;
import med.voll.api.model.PacienteDTO.DadosCadastroPaciente;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Endereco endereco;
    private boolean ativo;
    public Paciente(DadosCadastroPaciente dadosPaciente) {
        this.ativo = true;
        this.nome = dadosPaciente.nome();
        this.email = dadosPaciente.email();
        this.telefone = dadosPaciente.telefone();
        this.cpf = dadosPaciente.cpf();
        this.endereco = new Endereco(dadosPaciente.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dadosAtualizacaoPaciente) {
        if(dadosAtualizacaoPaciente.nome() != null){
            this.nome = dadosAtualizacaoPaciente.nome();
        }
        if(dadosAtualizacaoPaciente.telefone() != null){
            this.telefone = dadosAtualizacaoPaciente.telefone();
        }
        if(dadosAtualizacaoPaciente.endereco() != null){
            this.endereco.atualizarInformacoes(dadosAtualizacaoPaciente.endereco());
        }
    }

    public void excluir(long id) {
        this.ativo = false;
    }
}













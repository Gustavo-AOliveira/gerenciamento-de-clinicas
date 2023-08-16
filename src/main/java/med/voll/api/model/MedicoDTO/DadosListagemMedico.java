package med.voll.api.model.MedicoDTO;

import med.voll.api.model.domain.Medico;

public record DadosListagemMedico(Long id,String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}

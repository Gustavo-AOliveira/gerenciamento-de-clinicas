package med.voll.api.domain.Consulta.Validations.Agendamento;

import med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import med.voll.api.exception.ConsultaException;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoConsulta{
    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta data){

        if(data.idMedico() == null){
            return;
        }
        var medicoAtivo = repository.findAtivoById(data.idMedico());
        if(!medicoAtivo){
            throw new ConsultaException("Consulta não pode ser agendada com médico inativo");
        }
    }
}

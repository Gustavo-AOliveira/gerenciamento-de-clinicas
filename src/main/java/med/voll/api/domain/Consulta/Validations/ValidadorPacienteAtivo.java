package med.voll.api.domain.Consulta.Validations;

import med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import med.voll.api.exception.ConsultaException;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoConsulta{
    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta data){

        var pacienteAtivo = repository.findAtivoById(data.idPaciente());
        if(!pacienteAtivo){
            throw new ConsultaException("Consulta não pode ser agendada com paciente inativo");
        }

    }
}

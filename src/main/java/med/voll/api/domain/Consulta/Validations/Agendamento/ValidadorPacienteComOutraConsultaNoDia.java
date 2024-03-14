package med.voll.api.domain.Consulta.Validations.Agendamento;

import med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import med.voll.api.exception.ConsultaException;
import med.voll.api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteComOutraConsultaNoDia implements ValidadorAgendamentoConsulta{
    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta data){
        var primeiroHorario = data.data().withHour(7);
        var ultimoHorario = data.data().withHour(18);

        var pacientePossuiOutraConsultaNoDia =  repository.existsByPacienteIdAndDataBetween(data.idPaciente(), primeiroHorario, ultimoHorario);
        if(pacientePossuiOutraConsultaNoDia){
            throw new ConsultaException("Paciente já possui uma consulta agendada nesse dia");
        }
    }
}

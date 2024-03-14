package med.voll.api.domain.Consulta.Validations.Agendamento;

import med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import med.voll.api.exception.ConsultaException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class ValidadorHorarioFuncionamento implements ValidadorAgendamentoConsulta{

    public void validar(DadosAgendamentoConsulta data){
        var dataConsulta = data.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesAberturaClinica = dataConsulta.getHour() < 7;
        var depoisEncerramento = dataConsulta.getHour() > 18;

        if(domingo || antesAberturaClinica || depoisEncerramento){
            throw new ConsultaException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}

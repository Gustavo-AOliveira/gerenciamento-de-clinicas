package med.voll.api.domain.Consulta.Validations.Agendamento;

import med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import med.voll.api.exception.ConsultaException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoConsulta {

    public void validar(DadosAgendamentoConsulta data){

        var dataConsulta = data.data();
        var horaAgora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(horaAgora, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new ConsultaException("A consulta só pode ser marcada com 30 minutos de antecedência");
        }
    }
}

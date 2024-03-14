package med.voll.api.domain.Consulta.Validations.Cancelamento;

import jakarta.validation.ValidationException;
import med.voll.api.domain.Consulta.DadosCancelamentoConsulta;
import med.voll.api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ApenasCancelamento24HorasAntecedencia implements ValidadorCancelamentoConsulta {
    @Autowired
    private ConsultaRepository consultaRepository;
    public void validar(DadosCancelamentoConsulta data){

        var consulta = consultaRepository.getReferenceById(data.idConsulta());
        var horarioRequisicao = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(horarioRequisicao, consulta.getData()).toHours();

        if(diferencaEmHoras < 24){
            throw new ValidationException("Não é possível cancelar consulta com menos de 24 horas de antecedência");
        }


    }
}

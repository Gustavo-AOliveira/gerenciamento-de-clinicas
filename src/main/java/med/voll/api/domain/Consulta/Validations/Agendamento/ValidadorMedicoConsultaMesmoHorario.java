package med.voll.api.domain.Consulta.Validations.Agendamento;

import med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import med.voll.api.exception.ConsultaException;
import med.voll.api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoConsultaMesmoHorario implements ValidadorAgendamentoConsulta{
    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta data){
        var MedicoPossuiOutraConsultaMesmoHorario = repository.existsByMedicoIdAndData(data.idMedico(), data.data());
        if(MedicoPossuiOutraConsultaMesmoHorario){
            throw new ConsultaException("Médico já possui outra consulta agendada nesse horário");
        }
    }
}

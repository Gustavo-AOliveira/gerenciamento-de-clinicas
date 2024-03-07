package med.voll.api.domain.Consulta.Validations;

import med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import med.voll.api.exception.ConsultaException;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
@Component
public class ValidadorMedicoConsultaMesmoHorario implements ValidadorAgendamentoConsulta{
    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta data){
        var MedicoPossuiOutraConsultaMesmoHorario = repository.existsByMedicoIdAndData(data.idMedico(), data.data());
        if(MedicoPossuiOutraConsultaMesmoHorario){
            throw new ConsultaException("Médico já possui outra consulta agendada nesse horário");
        }
    }

}

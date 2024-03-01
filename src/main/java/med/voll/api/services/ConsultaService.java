package med.voll.api.services;

import jakarta.validation.ValidationException;
import med.voll.api.domain.Consulta.Consulta;
import med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.Medico.Medico;
import med.voll.api.repository.ConsultaRepository;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;


    public void agendar(DadosAgendamentoConsulta data){

        if(data.idMedico() != null && !medicoRepository.existsById(data.idMedico())){
            throw new ValidationException("Id do médico não encotrado");
        }
        if(!pacienteRepository.existsById(data.idPaciente())){
            throw new ValidationException("Id do paciente não encontrado");
        }

        var paciente = pacienteRepository.getReferenceById(data.idPaciente());
        var medico = randomMedico(data);

        var consulta = new Consulta(null, medico, paciente, data.data());
        consultaRepository.save(consulta);
    }

    private Medico randomMedico(DadosAgendamentoConsulta data) {
        if(data.idMedico() != null){
            medicoRepository.getReferenceById(data.idMedico());
        }
        if(data.especialidade() == null){
            throw new ValidationException("Adicione a especialidade");
        }
        return medicoRepository.randomMedicoDisponivel(data.especialidade(), data.data());

    }
}

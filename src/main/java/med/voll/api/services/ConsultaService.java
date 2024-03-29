package med.voll.api.services;

import jakarta.validation.ValidationException;
import med.voll.api.domain.Consulta.Consulta;
import med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.Consulta.DadosCancelamentoConsulta;
import med.voll.api.domain.Consulta.DadosDetalhamentoConsulta;
import med.voll.api.domain.Consulta.Validations.Agendamento.ValidadorAgendamentoConsulta;
import med.voll.api.domain.Consulta.Validations.Cancelamento.ValidadorCancelamentoConsulta;
import med.voll.api.domain.Medico.Medico;
import med.voll.api.exception.ConsultaException;
import med.voll.api.repository.ConsultaRepository;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoConsulta> validadores;
    @Autowired
    private List<ValidadorCancelamentoConsulta> validadoresCancelamento;


    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta data){

        if(!pacienteRepository.existsById(data.idPaciente())){
            throw new ValidationException("Id do paciente não encontrado");
        }

        if(data.idMedico() != null && !medicoRepository.existsById(data.idMedico())){
            throw new ValidationException("Id do médico não encotrado");
        }

         validadores.forEach(v -> v.validar(data));

        var paciente = pacienteRepository.getReferenceById(data.idPaciente());
        var medico = randomMedico(data);

        if (medico == null){
            throw new ValidationException("Não existe médico disponível nessa data");
        }

        var consulta = new Consulta(null, medico, paciente, data.data(),null);
        consultaRepository.save(consulta);

            return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico randomMedico(DadosAgendamentoConsulta data) {
        if(data.idMedico() != null){
            return  medicoRepository.getReferenceById(data.idMedico());
        }
        if(data.especialidade() == null){
            throw new ValidationException("Adicione a especialidade");
        }
            return medicoRepository.randomMedicoDisponivel(data.especialidade(), data.data());
    }

    public void cancelarAgendamento(DadosCancelamentoConsulta dados) {
        if(!consultaRepository.existsById(dados.idConsulta())){
            throw new ConsultaException("Consulta não encontrada");
        }

        validadoresCancelamento.forEach(v -> v.validar(dados));

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }
}

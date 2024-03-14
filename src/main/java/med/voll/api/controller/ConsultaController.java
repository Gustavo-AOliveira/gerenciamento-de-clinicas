package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.Consulta.Consulta;
import med.voll.api.domain.Consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.Consulta.DadosCancelamentoConsulta;
import med.voll.api.domain.Consulta.DadosDetalhamentoConsulta;
import med.voll.api.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    private ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
        var agendamento = consultaService.agendar(dados);
            return ResponseEntity.ok(agendamento);

    }
    @DeleteMapping
    public ResponseEntity cancelarAgendamento(@RequestBody @Valid DadosCancelamentoConsulta dados){
        consultaService.cancelarAgendamento(dados);
                return ResponseEntity.noContent().build();
    }

}

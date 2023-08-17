package med.voll.api.controller;

import med.voll.api.model.MedicoDTO.DadosDetalhamentoMedico;
import med.voll.api.model.PacienteDTO.DadosAtualizacaoPaciente;
import med.voll.api.model.PacienteDTO.DadosCadastroPaciente;
import med.voll.api.model.PacienteDTO.DadosDetalhamentoPaciente;
import med.voll.api.model.PacienteDTO.DadosListagemPaciente;
import jakarta.validation.Valid;
import med.voll.api.model.domain.Paciente;
import med.voll.api.model.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastraPaciente(@RequestBody @Valid DadosCadastroPaciente dadosPaciente, UriComponentsBuilder uriComponentsBuilder){
        var paciente = new Paciente(dadosPaciente);
            repository.save(paciente);
        var uri = uriComponentsBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
            return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listaOrdenada(@PageableDefault(size = 10, sort = {"nome"}, direction = Sort.Direction.ASC)Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
            return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dadosAtualizacaoPaciente){
        var paciente = repository.getReferenceById(dadosAtualizacaoPaciente.id());
        paciente.atualizarInformacoes(dadosAtualizacaoPaciente);
            return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir(id);
            return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
            return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));

    }
}










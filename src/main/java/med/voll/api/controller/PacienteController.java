package med.voll.api.controller;

import med.voll.api.model.PacienteDTO.DadosAtualizacaoPaciente;
import med.voll.api.model.PacienteDTO.DadosCadastroPaciente;
import med.voll.api.model.PacienteDTO.DadosListagemPaciente;
import jakarta.validation.Valid;
import med.voll.api.model.domain.Paciente;
import med.voll.api.model.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;
    @PostMapping
    @Transactional
    public void cadastraPaciente(@RequestBody @Valid DadosCadastroPaciente dadosPaciente){
        repository.save(new Paciente(dadosPaciente));
    }
    @GetMapping
    public Page<DadosListagemPaciente> listaOrdenada(@PageableDefault(size = 10, sort = {"nome"}, direction = Sort.Direction.ASC)Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dadosAtualizacaoPaciente){
        var paciente = repository.getReferenceById(dadosAtualizacaoPaciente.id());
        paciente.atualizarInformacoes(dadosAtualizacaoPaciente);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir(id);
    }
}










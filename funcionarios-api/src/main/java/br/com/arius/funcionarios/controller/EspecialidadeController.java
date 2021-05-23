package br.com.arius.funcionarios.controller;
import br.com.arius.funcionarios.model.Especialidade;
import br.com.arius.funcionarios.controller.dto.EspecialidadeDto;
import br.com.arius.funcionarios.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Classe responsavel pelas requisições com os metodos Salvar/Atualizar/Deletar/pesquisar por Id para Especialidade.
 * Autor: Jackson Santos
 *
 */

@RestController
@RequestMapping("/api/especialidade")
@CrossOrigin("http://localhost:4200")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService service;


    @GetMapping
    public ResponseEntity<List<EspecialidadeDto>>obterTodos(){
        List<EspecialidadeDto> tecnico = service.getTodos();
        return ResponseEntity.ok(tecnico);
    }

    @PostMapping
    public ResponseEntity<EspecialidadeDto> salvarEspecialidade(@RequestBody EspecialidadeDto especialidadeDto){
        Especialidade esp = service.salvarEspecialidade(especialidadeDto);
        return ResponseEntity.ok(especialidadeDto.create(esp));
    }


    @GetMapping("/{id}")
    public ResponseEntity buscarPorID(@PathVariable("id") Long id){
        Optional<EspecialidadeDto> tecnico = service.getEspecialidadeById(id);
        return ResponseEntity.ok(tecnico);
    }


    @PutMapping("/{id}")
    public ResponseEntity atualizarEspecialidade(@PathVariable("id") Long id, @RequestBody EspecialidadeDto especialidadeDto){

        especialidadeDto.setId(id);

        Especialidade f = service.atualizarEspecialidade(especialidadeDto,id);

        return f != null?
                ResponseEntity.ok(f) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable("id") Long id){
        service.deletarEspecialidade(id);

        return ResponseEntity.ok().build();
    }
}

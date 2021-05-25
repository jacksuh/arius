package br.com.arius.funcionarios.service;
import br.com.arius.funcionarios.model.Especialidade;
import br.com.arius.funcionarios.controller.dto.EspecialidadeDto;
import br.com.arius.funcionarios.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Classe para tratamento de dados e persistencia para o modelo Especialidade (regras de negocio).
 * Autor: Jackson Santos
 */

@Service
public class EspecialidadeService {

    @Autowired
    EspecialidadeRepository repository;



    public List<EspecialidadeDto> getTodos() {
        return repository.findAll().stream().map(EspecialidadeDto::create).collect(Collectors.toList());
    }



    public Especialidade salvarEspecialidade(EspecialidadeDto especialidadeDto){
        Especialidade esp = new Especialidade();
        esp.setDescricao(especialidadeDto.getDescricao());

        return repository.save(esp);

    }


    public Optional<EspecialidadeDto> getEspecialidadeById(Long id) {
        return repository.findById(id).map(EspecialidadeDto::create);
    }


    public Especialidade atualizarEspecialidade(EspecialidadeDto especialidadeDto, Long id) {
        Optional<Especialidade> optional = repository.findById(id);
        if (optional.isPresent()) {
            Especialidade db = optional.get();

            db.setDescricao(especialidadeDto.getDescricao());

            repository.save(db);

            return repository.save(db);
        } else {
            throw new RuntimeException("Não foi possivel atualizar o cadastro");
        }
    }


    public void deletarEspecialidade(Long id){
        Optional<Especialidade> funcionario = repository.findById(id);
        if(funcionario.isPresent()){
            repository.deleteById(id);
        }
    }


}

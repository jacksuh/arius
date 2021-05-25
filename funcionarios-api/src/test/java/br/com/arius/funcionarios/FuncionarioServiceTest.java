package br.com.arius.funcionarios;


import br.com.arius.funcionarios.controller.dto.EspecialidadeDto;
import br.com.arius.funcionarios.controller.dto.FuncionarioDto;
import br.com.arius.funcionarios.model.Especialidade;
import br.com.arius.funcionarios.model.Funcionario;
import br.com.arius.funcionarios.service.EspecialidadeService;
import br.com.arius.funcionarios.service.FuncionarioService;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Testes escritos para testar as funcionalidades da aplicação.
 */

@SpringBootTest
public class FuncionarioServiceTest {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private EspecialidadeService especialidadeService;

    @Test
    public void testSalvarFuncionario(){

        EspecialidadeDto e = new EspecialidadeDto();
        e.setDescricao("Tecnico teste");

        Especialidade esp = especialidadeService.salvarEspecialidade(e);


        FuncionarioDto f = new FuncionarioDto();
        f.setNome("Jackson Santos");
        f.setTelefone("972365956");
        f.setEmail("jackson@teste.com.br");
        f.setEspecialidadeDto(e.create(esp));

        Funcionario fu = funcionarioService.salvarFuncionario(f);

        Assert.assertEquals("Jackson Santos", fu.getNome());
        Assert.assertEquals("Tecnico teste", e.getDescricao());

    }

    //Atualização do funcionario
    @Test
    public void testAtualizacaoFuncionario(){

        EspecialidadeDto e = new EspecialidadeDto();
        e.setDescricao("Tecnico teste");

        Especialidade esp = especialidadeService.salvarEspecialidade(e);

        FuncionarioDto f = new FuncionarioDto();
        f.setNome("Jackson Santos");
        f.setTelefone("972365956");
        f.setEmail("jackson@teste.com.br");
        f.setEspecialidadeDto(e.create(esp));

        Funcionario fu = funcionarioService.salvarFuncionario(f);

        Long id = fu.getId();

        FuncionarioDto atualizar = new FuncionarioDto();
        atualizar.setId(id);
        atualizar.setEspecialidadeDto(e.create(esp));
        atualizar.setNome("Jackson Silva dos Santos");

        Funcionario atualizado = funcionarioService.atualizarFuncionario(atualizar, id);

        Assert.assertEquals("Jackson Silva dos Santos", atualizado.getNome());
    }

    //Teste deletar Funcionario
    @Test
    public void testDeletarFuncionario(){

        EspecialidadeDto e = new EspecialidadeDto();
        e.setDescricao("Tecnico teste");

        Especialidade esp = especialidadeService.salvarEspecialidade(e);


        FuncionarioDto f = new FuncionarioDto();
        f.setNome("Jackson Santos");
        f.setTelefone("972365956");
        f.setEmail("jackson@teste.com.br");
        f.setEspecialidadeDto(e.create(esp));

        Funcionario fu = funcionarioService.salvarFuncionario(f);


        Long id = fu.getId();
        Long idEsp = esp.getId();

        funcionarioService.deletarFuncionario(id);
        especialidadeService.deletarEspecialidade(idEsp);

        funcionarioService.getFuncionarioById(id);
        especialidadeService.getEspecialidadeById(idEsp);

    }

    //Lista retorno esperado 1 registros OK.
    @Test
    @Disabled
    public void testListarFuncionario() {
        List<FuncionarioDto> funcionarioDto = funcionarioService.getTodos();

        Assert.assertEquals(1, funcionarioDto.size());
    }

}

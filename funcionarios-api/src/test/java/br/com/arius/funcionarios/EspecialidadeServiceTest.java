package br.com.arius.funcionarios;

import br.com.arius.funcionarios.controller.dto.EspecialidadeDto;
import br.com.arius.funcionarios.model.Especialidade;
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
public class EspecialidadeServiceTest {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private EspecialidadeService especialidadeService;

    //Teste para salvar e fazer comparação de dados.
    @Test
    public void testSalvarEspecialidade(){

        EspecialidadeDto e = new EspecialidadeDto();
        e.setDescricao("Tecnico teste");

        Especialidade esp = especialidadeService.salvarEspecialidade(e);

        Assert.assertNotNull(e);
        Assert.assertNotNull(esp.getId());
        Assert.assertEquals("Tecnico teste", e.getDescricao());

    }


    @Test
    public void testAtualizacaoEspecialidade(){

        EspecialidadeDto e = new EspecialidadeDto();
        e.setDescricao("Tecnico teste");

        Especialidade esp = especialidadeService.salvarEspecialidade(e);

        Long id = esp.getId();

        EspecialidadeDto atualizar = new EspecialidadeDto();
        atualizar.setId(id);
        atualizar.setDescricao("Tecnico De Telefonia");

        Especialidade atualizado = especialidadeService.atualizarEspecialidade(atualizar, id);

        Assert.assertEquals("Tecnico De Telefonia", atualizar.getDescricao());
    }


    //Lista retorno esperado 2 registros OK.
    @Test
    @Disabled
    public void testListarEspecialidade() {
        List<EspecialidadeDto> especialidadeDto = especialidadeService.getTodos();

        Assert.assertEquals(1, especialidadeDto.size());
    }

    //Teste para deletar dados.
    @Test
    public void testDeletarEspecialidade(){

        EspecialidadeDto e = new EspecialidadeDto();
        e.setDescricao("Tecnico teste");

        Especialidade esp = especialidadeService.salvarEspecialidade(e);

        Long id = esp.getId();
        Assert.assertNotNull(id);

        especialidadeService.deletarEspecialidade(id);


        especialidadeService.getEspecialidadeById(id);

    }

}

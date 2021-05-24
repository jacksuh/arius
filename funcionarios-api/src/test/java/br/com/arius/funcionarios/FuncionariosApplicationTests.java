package br.com.arius.funcionarios;

import br.com.arius.funcionarios.controller.dto.EspecialidadeDto;
import br.com.arius.funcionarios.controller.dto.FuncionarioDto;
import br.com.arius.funcionarios.model.Especialidade;
import br.com.arius.funcionarios.service.EspecialidadeService;
import br.com.arius.funcionarios.service.FuncionarioService;
import org.junit.jupiter.api.Test;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;


@SpringBootTest
class FuncionariosApplicationTests {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private EspecialidadeService especialidadeService;



	//Lista retorno esperado 1 registros OK.
	@Test
	public void testListarFuncionario() {
		List<FuncionarioDto> funcionarioDto = funcionarioService.getTodos();

		Assert.assertEquals(1, funcionarioDto.size());
	}



	//Teste para salvar e fazer comparação de dados.
	@Test
	public void testSalvarEspecialidade(){

		EspecialidadeDto e = new EspecialidadeDto();
		e.setDescricao("Tecnico de teste");

		especialidadeService.salvarEspecialidade(e);

		Assert.assertNotNull(e);
		Assert.assertEquals("Tecnico de teste", e.getDescricao());

	}

	//Lista retorno esperado 2 registros OK.
	@Test
	public void testListarEspecialidade() {
		List<EspecialidadeDto> especialidadeDto = especialidadeService.getTodos();

		Assert.assertEquals(1, especialidadeDto.size());
	}


}

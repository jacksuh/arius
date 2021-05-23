package br.com.arius.funcionarios.controller.dto;
import br.com.arius.funcionarios.model.Funcionario;
import org.modelmapper.ModelMapper;

/**
 * Classe FuncionarioDto - Data Transfer Object, responsavel pelo tratamento de dados passados pelo front-end, tratamento de conversão utilizando o Mapper.
 * Autor: Jackson Santos
 *
 */

public class FuncionarioDto {

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private EspecialidadeDto especialidadeDto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EspecialidadeDto getEspecialidadeDto() {
        return especialidadeDto;
    }

    public void setEspecialidadeDto(EspecialidadeDto especialidadeDto) {
        this.especialidadeDto = especialidadeDto;
    }

    public static FuncionarioDto create(Funcionario funcionario){
        ModelMapper modelMapper = new ModelMapper();

        FuncionarioDto map = modelMapper.map(funcionario, FuncionarioDto.class);
        EspecialidadeDto espDto = new EspecialidadeDto();
        espDto.setId(funcionario.getEspecialidade().getId());
        espDto.setDescricao(funcionario.getEspecialidade().getDescricao());
        map.setEspecialidadeDto(espDto);
        return map;
    }
}

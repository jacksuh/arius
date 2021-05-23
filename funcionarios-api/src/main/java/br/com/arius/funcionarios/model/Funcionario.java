package br.com.arius.funcionarios.model;
import javax.persistence.*;

/**
 * Classe para declaração de dados e persistencia com o banco de dados, sera criado a tabela tecnicos.
 * Tratamento de cardinalidade N-1.
 *
 * Autor: Jackson Santos
 */

@Entity
@Table(name ="tecnicos")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idEspecialidade")
    private Especialidade especialidade;

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

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}

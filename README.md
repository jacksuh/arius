#Desafio

##Como executar projeto funcionarios-api
Clone os Projetos para um diretorio qualquer em seu computador.

```bash
git clone https://github.com/jacksuh/arius.git
```

Em seguida navegue até o diretorio criado.
```
cd arius/funcionarios-api
```

### Projeto não foi configurado com o  Docker, será necessario ter em sua maquina.
- [MySQL](https://www.mysql.com/)

Execute o comando: CMD 
```bash
mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=local
```

##Como acessar
Certificando que esta rodando corretamente execute o proximo projeto Angular.

##Como executar projeto funcionarios-app

Projeto Angular foi gerado com [Angular CLI](https://github.com/angular/angular-cli) Version 9.1.8.


#navegue até o diretorio do projeto funcionarios-app

Execute `ng serve` após subir o projeto acesse : `http://localhost:4200/`


##Sobre o Desafio.<p>
    ##Sobre a Api.
    #Funcionario<p>
    - Cadastro de Funcionario pode ser feito pelo caminho POST - http://localhost:8080/api/funcionario<p> 
    - Pesquisar todos os dados GET - http://localhost:8080/api/funcionario<p>
    - Pesquisar por id GET http://localhost:8080/api/funcionario/id<p>
    - Atualizar, deletar: PUT e DELETE http://localhost:8080/api/funcionario/id<p>
    #Especialidade<p>
    - Cadastro de Especialidade: http://localhost:8080/api/especialidade<p>
    - Pesquisar todas as especialidades GET - http://localhost:8080/api/especialidade<p>
    - Pesquisar por id GET http://localhost:8080/api/especialidade/id<p>
    - Atualizar, deletar: PUT e DELETE http://localhost:8080/api/especialidar /id<p>
    - Utilizado estrutura MVC e utilização da classe DTO Data Transfer Object.<p>
    - Relacionamento de N-1 utilizando o Spring.<p>

    ##Sobre o Angular.<p>
    - Foi criado um projeto simples para validar a APIrest java.<p>
    - Adicionado no layout cadastro de Especialidade e cadastro de Funcionario.<p>

    ##Testes Unitario<p>
    - Testes realizados utilizando o Junit-4.

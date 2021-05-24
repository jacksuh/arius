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

Execute `ng serve` após subir o projeto acesse : `http://localhost:4200/


##Sobre o Desafio.
    ##Sobre a Api.
    #Funcionario
    - Cadastro de Funcionario pode ser feito pelo caminho POST - http://localhost:8080/api/funcionario 
    - Pesquisar todos os dados GET - http://localhost:8080/api/funcionario
    - Pesquisar por id GET http://localhost:8080/api/funcionario/id
    - Atualizar, deletar: PUT e DELETE http://localhost:8080/api/funcionario/id
    #Especialidade
    - Cadastro de Especialidade: http://localhost:8080/api/especialidade
    - Pesquisar todas as especialidades GET - http://localhost:8080/api/especialidade
    - Pesquisar por id GET http://localhost:8080/api/especialidade/id
    - Atualizar, deletar: PUT e DELETE http://localhost:8080/api/especialidar /id
    - Utilizado estrutura MVC e utilização da classe DTO Data Transfer Object.
    - Relacionamento de N-1 utilizando o Spring.

    ##Sobre o Angular.
    - Foi criado um projeto simples para validar a APIrest java.
    - Adicionado no layout cadastro de Especialidade e cadastro de Funcionario.

    ##Testes Unitario
    - Testes realizados utilizando o Junit-4.

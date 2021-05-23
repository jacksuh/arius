export class Funcionario {
    id: number;
    nome: string;
    telefone: string;
    email: string;
    especialidadeDto: {id:number};

    constructor(){
        this.especialidadeDto = {id:0};
    }
}
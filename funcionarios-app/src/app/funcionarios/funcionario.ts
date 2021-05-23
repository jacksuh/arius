export class Funcionario {
    id: number;
    nome: string;
    especialidadeDto: {id:number};

    constructor(){
        this.especialidadeDto = {id:0};
    }
}
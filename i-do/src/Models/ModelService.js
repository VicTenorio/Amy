import {getServicesByUser} from '../Requests/servicesRequest';

export default class Service{
    
    constructor(id,
    idUsuario,
    endereco,
    idCategoria,
    Imagem,
    nome,
    descricao,
    tempoExecucao,
    preco,
    localizacaoFixa){
        this.state = {
            id :id,
            idUsuario: idUsuario,
            endereco: endereco,
            idCategoria: idCategoria,
            nome: nome,
            descricao: descricao,
            tempoExecucao: tempoExecucao,
            preco: preco,
            localizacaoFixa: localizacaoFixa,
            Imagem: Imagem
        }
    }

    Save(){
        
    }

    delete(){

    }

    update(){

    }      
}

export function get(id){

}

export function getAll(){

}


export function getAllByUser(userId){
    const req =  getServicesByUser(userId);
}   


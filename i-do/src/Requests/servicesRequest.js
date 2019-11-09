import Service from '../Models/ModelService';
import axios from 'axios'

const endpoint = 'http://localhost:8080/';

export default null;

export function saveSevice(newService) {
    axios({
        method: 'post',
        url: this.endpoint + '/Servico',
        data: newService
    })
        .then(response => {
            if (response.status == 200) {
                return populate(response.data);
            }
        })
        .catch(error => {
            console.log(error)
        })
}

export function getServicesByUser(userId) {
    axios.get((endpoint + "/Prestador/Servicos?id=" + userId))
        .then(function (response) {
            if (response.status == 200) {
                console.log(populate(response.data));
            }
        });
}


function populate(data) {
    let listServices = []
    data.forEach(element => {
        listServices.push(new Service(
            element.id,
            element.idUsuario,
            element.endereco,
            element.idCategoria,
            element.nome,
            element.descricao,
            element.tempoExecucao,
            element.preco,
            element.localizacaoFixa,
            element.imagem)
        );
    });
    return listServices
} 

import Axios from 'axios';

export default function serviceRegisterRequest() {
    const nome = document.getElementById("txtName").value;
    const preco = document.getElementById("txtPrice").value;
    const descricao = document.getElementById("txtDescription").value;
    const tempoExecucao = document.getElementById("txtTime").value;

    var escolhaLocalizacao = '';
    var localizacao = document.getElementsByName('localServico');
    for (var i = 0; i < localizacao.length; i++) {
        if (localizacao[i].checked) {
            escolhaLocalizacao = localizacao[i].value;
        }
    }

    const params = {
        idServico: null,
        idUsuario: 10,
        idCategoria: 1,
        nome,
        preco,
        descricao,
        tempoExecucao,
        endereco: {
            rua: "Rua Das Orquideas",
            cep: "0000-000",
            complemento: null,
            pais: "A Terra do REU",
            id_Endereco: 224,
            numero: "69",
            referencia: null,
            bairro: "Jardim das Flores",
            cidade: "Porto Real",
            estado: "UK"
        },
        imagem: null
    }

    console.log(params)

    Axios.post('https://ravenamy.azurewebsites.net/Servico', params)
        .then(Response => {
            console.log(Response)
        })
        .catch(Error => {
            console.log(Error)
        })
}
import Axios from 'axios';

export default function serviceRegisterRequest() {

    const nome = document.getElementById("txtName").value;
    const preco = document.getElementById("txtPrice").value;
    const descricao = document.getElementById("txtDescription").value;
    const tempoExecucao = document.getElementById("txtTime").value;
    var escolhaLocalizacao = [];
    var localizacao = document.getElementsByName('localServico');
    for (var i = 0; i < localizacao.length; i++) {
        if (localizacao[i].checked) {
            escolhaLocalizacao.push(localizacao[i].value);
        }
    }

    console.log(escolhaLocalizacao)

    if(escolhaLocalizacao)
    {
        
    }

    const params = [
        { nome, preco, descricao, tempoExecucao }
    ]

    Axios.post('https://ravenamy.azurewebsites.net/servico', params)
        .then(Response => {
            console.log(Response)
        })
        .catch(Error => {
            console.log(Error)
        })
}
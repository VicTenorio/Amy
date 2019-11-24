import axios from 'axios';

export default function Cep() {
    
    const cep = document.getElementById("txtCep").value;
    const bairro = document.getElementById("txtBairro");
    const cidade = document.getElementById("txtCidade");
    const rua = document.getElementById("txtRua");

    if (cep != "") {
        axios.get(`https://viacep.com.br/ws/${cep}/json/`)
            .then(Response => {
                console.log(Response)
                var dados = Response.data
                if (Response.status === 200) {
                    bairro.value = dados.bairro;
                    cidade.value = dados.localidade;
                    rua.value = dados.logradouro;
                }
            })
            .catch(Error => {
                console.log(Error)
                alert('Ocorreu um erro')
            })
    }
}
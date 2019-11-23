import Axios from 'axios';

export default function serviceRegisterRequest() {
    const nome = document.getElementById("txtName").value;
    const preco = document.getElementById("txtPrice").value;
    const descricao = document.getElementById("txtDescription").value;
    const tempoExecucao = document.getElementById("txtTime").value;

    const blob = document.getElementById("foto").src

    const toDataURL = url => fetch(url)
    .then(response => response.blob())
    .then(blob => new Promise((resolve, reject) => {
      const reader = new FileReader()
      reader.onloadend = () => resolve(reader.result)
      reader.onerror = reject
      reader.readAsDataURL(blob)
    }))
  
    var image = async () =>  await toDataURL(blob)
    .then(dataUrl => {
      return dataUrl
    })
console.log("image", image())
    var escolhaLocalizacao = '';
    var localizacao = document.getElementsByName('localServico');
    for (var i = 0; i < localizacao.length; i++) {
        if (localizacao[i].checked) {
            escolhaLocalizacao = localizacao[i].value;
        }
    }

    const params = {
        id: null,
        idUsuario: 882,
        idCategoria: 1,
        nome,
        preco,
        descricao,
        tempoExecucao,
        localizacaoFixa: true,
        endereco: {
            id_Endereco: null,
            rua: "Rua Das Orquideas",
            cep: "0000-000",
            complemento: "aa",
            pais: "A Terra do REU",
            numero: "69",
            referencia: "aa",
            bairro: "Jardim das Flores",
            cidade: "Porto Real",
            estado: "UK"
        },
        imagem: [
            {
                id: null,
                idUsuario: 882,
                url: " ",
                image: " "
            }
        ] 
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
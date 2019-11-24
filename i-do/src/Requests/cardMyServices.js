import Axios from 'axios';

export default function MyServicesRequest() {
    const nomeServico = document.getElementByI("ServiceName");
    const descricao = document.getElementById("ServiceDescription");
    const price = document.getElementById("ServicePrice");

    const params = {
        nome: "Pedreiro",
        descricaoService: "Faço serviços de num sei o que e bla bla bla e bla bla bla",
        preco: "2,00"
    }

    Axios.get('https://ravenamy.azurewebsites.net/Prestador/Servicos')
        .then(Response => {
            console.log(Response)
        })
        .catch(Error => {
            console.log(Error)
        })

}
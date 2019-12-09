import Axios from 'axios'
import service from './ConnectionString';

export default function userRequest() {
    const nome = document.getElementById("txtNome").value
    const RG = document.getElementById("txtRg").value
    const cpfCnpj = document.getElementById("txtCpf").value
    const dataNascimento = document.getElementById("txtDataNascimento").value
    const estadoCivil = document.getElementById("estadoCivil")
    const option = estadoCivil.selectedIndex;
    const optionFinal = estadoCivil.options[option].text;

    var escolhaSexo;
    const genero = document.getElementsByName("sexo")
    for (var i = 0; i < genero.length; i++) {
        if (genero[i].checked) {
            escolhaSexo = genero[i].value
        }
    }

    const email = document.getElementById("txtEmail").value
    const telefone = document.getElementById("txtTelefone").value
    const senha = document.getElementById("txtSenha").value
    const rua = document.getElementById("txtRua").value
    const numero = document.getElementById("txtNumero").value
    const referencia = document.getElementById("txtReferencia").value
    const complemento = document.getElementById("txtComplemento").value
    const cep = document.getElementById("txtCep").value
    const bairro = document.getElementById("txtBairro").value
    const cidade = document.getElementById("txtCidade").value
    const estado = document.getElementById("txtEstado").value

    const params = {
        nome,
        email,
        senha,
        endereco: {
            rua,
            cep,
            complemento,
            numero,
            referencia,
            bairro,
            cidade,
            estado,
            pais: "Brasil",
        },
        imagem: null,
        cpfCnpj,
        RG,
        telefone,
        prestador: true,
        estadoCivil: optionFinal,
        sexo: "M",
        dataNascimento
    }

    Axios.post(service() + 'cadastro', params)
        .then(Response => {
            const flieDoc = document.getElementById("fileDoc").src;

            if (flieDoc != null) {
                const toDataURL = url => fetch(url)
                    .then(response => response.blob())
                    .then(blob => new Promise((resolve, reject) => {
                        const reader = new FileReader()
                        reader.onloadend = () => resolve(reader.result)
                        reader.onerror = reject
                        reader.readAsDataURL(blob)
                    }))

                toDataURL(flieDoc)
                    .then(dataUrl => {
                        localStorage.setItem("imagemDoc", dataUrl.substring(23, dataUrl.length))
                    })

                const imageDoc =
                {
                    "Id": 0,
                    "idUser": Response.data.id,
                    "imagem": localStorage.getItem("imagemDoc")
                }

                console.log(imageDoc)
                Axios.post('https://rehab-amy.azurewebsites.net/api/document', imageDoc)
                    .then(Response => {
                        console.log(Response)
                    })
                    .catch(Error => {
                        console.log(Error)
                    })

            }
            console.log(Response)
        })
        .catch(Error => {
            console.log(Error)
        })

}

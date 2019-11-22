import axios from 'axios';

export function cep(cep) {

    while (cep != null) {
        axios.get("https://viacep.com.br/ws/" + cep + "/json/")

            .then(response => (
                console.log("res", response)
            )
        )
    }
}
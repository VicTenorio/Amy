import React from 'react'
import '../assets/css/successfullyRegister.css'
import { Link } from 'react-router-dom';

class SuccessfullyRegister extends React.Component {
    render() {
        return (
            <div className="p-3">
                <div class="alert alert-success" role="alert">
                    <h4 class="alert-heading">Cadastrado com sucesso!</h4>
                    <p>Agora seus documentos estão sendo analisados pelos administradores da I do. Entraremos em contato quando a aprovação for finalizada.</p>
                </div>
                <Link to="/" className="link row w-100 justify-content-center mt-5">
                    <button id="btnConcluir">Concluir</button>
                </Link>
                
            </div>
        )
    }
}

export default SuccessfullyRegister
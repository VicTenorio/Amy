import React from 'react';
import '../assets/css/userRegister.css';
import NavbarRegister from '../components/navbar-register';
import { cep } from './apiCorreios';

class userRegister extends React.Component {
    render() {
        return (
            <div>
                <NavbarRegister />
                <form>
                    <div class="row title-register">
                        <p>Dados Pessoais</p>
                    </div>
                    <div className="row">
                        <div class="row w-100">
                            <p>Nome</p>
                        </div>
                        <div class="row w-100">
                            <input class="input-name" />
                        </div>
                    </div>
                    <div class="row title-register">
                        <p>Dados de Acesso e Contato</p>
                    </div>
                    <div class="row title-register">
                        <p>Endereço</p>
                    </div>
                </form>
            </div>
        )
    }
}

export default userRegister;
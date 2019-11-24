import React from 'react';
import '../assets/css/login.css';
import {Link} from 'react-router-dom';
import login from '../Requests/loginRequest';

class Login extends React.Component {
    render() {
        return (
            <div class="bg-login">
                <div class="container" id="form">
                    <div class="row">
                        <input type="text" id="txtUser" placeholder="usuário"></input>
                    </div>
                    <div class="row mt-4">
                        <input type="text" id="txtPass" placeholder="senha"></input>
                    </div>
                    <div class="row mt-4">
                        <button id="btn-login" onClick={login}>entrar</button>
                    </div>
                    <div class="row mt-2">
                        <p>Esqueceu sua senha? Clique aqui!</p>
                    </div>
                    <div class="row mt-2 ml-1">
                        <p>Sem login?
                            <Link to="/cadastroDeUsuario">
                                <span>Cadastre-se aqui!</span>
                            </Link>
                        </p>
                    </div>
                </div>
            </div>

        )
    }
}

export default Login;
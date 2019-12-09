import React from 'react';
import '../assets/css/login.css';
import { Link } from 'react-router-dom';
import login from '../Requests/loginRequest';
import Logo from '../assets/images/ido-logo.png';

class Login extends React.Component {
    render() {
        return (
            <div id="tudo">
                <div class="bg-login">
                    <div class="container" id="form">
                        <div className="row">
                            <Link to="/">
                                <img id="logoLogin" src={Logo} alt="logo" />
                            </Link>
                        </div>
                        <div class="row">
                            <input type="text" id="txtUser" placeholder="usuário"></input>
                        </div>
                        <div class="row mt-4">
                            <input type="password" id="txtPass" placeholder="senha"></input>
                        </div>
                        <div class="row mt-4">
                            <button id="btn-login" onClick={login}>entrar</button>
                        </div>
                        <div class="row mt-4 ml-1">
                            <p>Sem login?
                            <Link to="/cadastroDeUsuario">
                                    <span className="ml-2">Cadastre-se aqui!</span>
                                </Link>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default Login;
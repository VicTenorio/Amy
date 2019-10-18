import React from 'react';
import '../assets/css/login.css';
import '../Requests/loginRequest'

class Login extends React.Component {
    render() {
        return (
            <div class="bg-login">
                <form class="container" id="form">
                    <div class="row">
                        <input type="text" id="user-input" placeholder="usuário"></input>
                    </div>
                    <div class="row mt-4">
                        <input type="text" id="password-input" placeholder="senha"></input>
                    </div>
                    <div class="row mt-4">
                        <button id="btn-login" type="submit" onClick="loginRequest">entrar</button>
                    </div>
                    <div class="row mt-2">
                        <p>Esqueceu sua senha? Clique aqui!</p>
                    </div>
                    <div class="row mt-2 ml-1">
                        <p>Sem login? <span>Cadastre-se aqui!</span></p>
                    </div>
                </form>
            </div>

    )}   
}

export default Login;
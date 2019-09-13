import React from 'react';
import '../assets/css/login.css';

class Login extends React.Component {
    render() {
        return (
            <div class="bg-login">
                <div class="container">
                    <div class="row">
                        <input type="text" id="user-input" placeholder="usuário"></input>
                    </div>
                    <div class="row mt-4">
                        <input type="text" id="password-input" placeholder="senha"></input>
                    </div>
                    <div class="row mt-4">
                        <button id="btn-login">entrar</button>
                    </div>
                    <div class="row mt-2">
                        <p>Esqueceu sua senha? Clique aqui!</p>
                    </div>
                    <div class="row mt-2 ml-1">
                        <p>Sem login? <span>Cadastre-se aqui!</span></p>
                    </div>
                </div>
            </div>

    )}   
}

export default Login;
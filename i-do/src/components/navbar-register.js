import React from 'react';
import '../assets/css/navbarRegister.css';
import { Link } from 'react-router-dom';
import logoCinza from '../assets/images/ido-cinza.png';

class NavbarRegister extends React.Component {
    render() {
        return (
            <div className="navbar-container">
                <div className="row justify-content-end">
                    <div className="register-nav-text">
                    <span class="link-gray justify-content-center">Já tem uma conta?</span>
                    <span class="link-orange">
                        <Link class="link-orange" to="/login"> Faça login aqui!
                        </Link>
                    </span>
                    </div>
                </div>
                <div className="row justify-content-center">
                    <label className="register-nav-title">Conecte-se a oportunidades</label>
                </div>
                <div className="row justify-content-center">
                    <label className="register-nav-subtitle">Cadastre-se na I do, é rápido e gratuito</label>
                </div>
            </div>
         )
    };
}

export default NavbarRegister;
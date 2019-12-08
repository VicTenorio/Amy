import React from 'react';
import '../assets/css/navbarRegister.css';
import { Link } from 'react-router-dom';
import logo from '../assets/images/ido-logo.png';

class NavbarRegister extends React.Component {
    render() {
        return (
            <div className="navbar-container">
                <div className="row w-100">
                    <div className="register-nav-text row w-100">
                        <div className="col" align="right">
                            <span class="link-gray justify-content-center">Já tem uma conta?</span>
                            <span class="link-orange">
                                <Link class="link-orange" to="/login"> Faça login aqui!
                                </Link>
                            </span>
                        </div>
                    </div>
                </div>
                <div className="row w-100">
                    <div className="col-xl-11 justify-content-center">
                        <div className="row justify-content-center">
                            <label className="register-nav-title mt-5">Conecte-se a oportunidades</label>
                        </div>
                        <div className="row justify-content-center">
                            <label className="register-nav-subtitle">Cadastre-se na I do, é rápido e gratuito</label>
                        </div>
                    </div>
                </div>
            </div>
        )
    };
}

export default NavbarRegister;
import React from 'react';
import { Link } from 'react-router-dom';
import '../assets/css/navbarLogged.css';
import logo from '../assets/images/ido-logo.png';

class NavbarLogged extends React.Component {
    render() {
        return (
            <div className="navLogged">
                <nav id="navLogged" className="row w-100 navbar bg-transparent">
                    <div className="col">
                        <Link to="/">
                            <img id="logoServices" src={logo} />
                        </Link>
                    </div>
                    <form id="form" className="col-xl-9 justify-content-center">
                        <Link to="/meusServicos">
                            <button id="btnMeusServicos" className="btnNavLogged">Meus serviços</button>
                        </Link>
                        <Link to="/servicosAgendados">
                            <button id="btnAgendamentos" className="btnNavLogged pr-5 pl-5">Meus agendamentos</button>
                        </Link>
                        <Link to="/cadastroDeServico">
                            <button id="btnCadastroServico" className="btnNavLogged">Cadastre seus serviços</button>
                        </Link>
                    </form>
                </nav>
            </div>
        )
    }
}

export default NavbarLogged;
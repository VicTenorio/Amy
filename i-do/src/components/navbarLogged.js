import React from 'react';
import { Link } from 'react-router-dom';
import '../assets/css/navbarLogged.css';
import logoCinza from '../assets/images/ido-preto.png';

class NavbarLogged extends React.Component {
    render() {
        return (
            <div className="navLogged">
                <nav id="navLogged" className="navbar navbar-expand-lg bg-transparent">
                    <Link to="/" className="navbar-brand">
                        <img id="logoServices" src={logoCinza} />
                    </Link>
                    <form id="form" className="row w-100 form-inline justify-content-center p-3">
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
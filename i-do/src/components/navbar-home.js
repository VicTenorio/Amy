import React from 'react';
import '../assets/css/navbar.css';
import { Link } from 'react-router-dom';
import logoCinza from '../assets/images/ido-preto.png';

class Navbar extends React.Component {
    render() {
        return (
            <div>
                <nav id="navbar" className="navbar navbar-expand-lg bg-transparent">
                    <Link to="/" className="navbar-brand">
                        <img id="logoHome" src={logoCinza} />
                    </Link>
                    <button className="navbar-toggler border-warning" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarText">
                        <form className="row w-100 form-inline justify-content-end p-3">
                            <div className="row" align="center">
                                <div className="col-7">
                                    <Link to="/cadastroDeUsuario">
                                        <button id="btnCadastroNavbar" className="form-control mr-sm-2">Cadastre-se!</button>
                                    </Link>
                                </div>
                                <div className="col-5">
                                    <Link to="/login">
                                        <button id="btnLoginNavbar" className="btn my-2 my-sm-0" type="submit">Login</button>
                                    </Link>
                                </div>
                            </div>
                        </form>
                    </div>
                </nav>
            </div>
        )
    };
}

export default Navbar;
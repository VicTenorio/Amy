import React from 'react';
import '../assets/css/homeLogoff.css';
import { Link } from 'react-router-dom';
import logo from '../assets/images/ido-logo.png';

class HomeLogoff extends React.Component {
    render() {
        return (
            <div>
                <div id="bodyLogoff">
                    <div className="col-xl-12" align="center">
                        <img id="logoHomeLogoff" src={logo} alt="logo"/>
                        <h1 id="title">Vamos começar?</h1>
                        <div align="center">
                            <p id="text">Explore o lugar perfeito para realizar seus serviços e gerenciá-los com facilidade.</p>
                        </div>
                    </div>
                    <form id="btnsAccess" className="row w-100 form-inline justify-content-center">
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
            </div>
        )
    }
}

export default HomeLogoff
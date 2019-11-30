import React from 'react';
import '../assets/css/homeLogoff.css';
import { Link } from 'react-router-dom';
import logoCinza from '../assets/images/ido-preto.png';

class HomeLogoff extends React.Component {
    render() {
        return (
            <div>
                <div id="bodyLogoff">
                    <div className="col-xl-12" align="center">
                        <img id="logoHomeLogoff" src={logoCinza} alt="logo"/>
                        <h1 id="title">Vamos começar?</h1>
                        <div align="center">
                            <p id="text" style={{color: '#A7A7A7'}}>Explore o lugar perfeito para realizar seus serviços e gerenciá-los com facilidade.</p>
                        </div>
                    </div>
                    <form className="row w-100 form-inline justify-content-center p-3">
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
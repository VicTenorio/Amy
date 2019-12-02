import React from 'react';
import '../assets/css/navbar.css';
import { Link } from 'react-router-dom';
import logo from '../assets/images/ido-logo.png';

class Navbar extends React.Component {
    render() {
        return (
            <div>
                <nav id="navbar" className="navbar navbar-expand-lg bg-transparent">
                    <Link to="/" className="col">
                        <img id="logoHome" src={logo} />
                    </Link>
                    <button className="navbar-toggler border-warning" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarText">
                        <form className="row w-100 form-inline justify-content-end p-3">
                            <div className="row" align="center">
                                <label id="userName" className="display-4">
                                    Bem vindo, Usuário!
                                </label>
                            </div>
                        </form>
                    </div>
                </nav>
            </div>
        )
    };
}

export default Navbar;
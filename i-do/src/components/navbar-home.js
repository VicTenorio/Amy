import React from 'react';
import '../assets/css/navbar.css';

class Navbar extends React.Component {
    render() {
        return (
            <div>
                <nav id="navbar" className="navbar navbar-expand-lg navbar-light bg-light">
                    <a className="navbar-brand">Logo</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarText">
                        <form className="row w-100 form-inline justify-content-end">
                            <div className="row">
                                <div className="col-xl-8 col-lg-8 col-md-8">
                                    <button id="btnCadastroNavbar" className="form-control mr-sm-2">Cadastre-se!</button>
                                </div>
                                <div className="col-xl-4 col-lg-4 col-md-4">
                                    <button id="btnLoginNavbar" className="btn my-2 my-sm-0" type="submit">Login</button>
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
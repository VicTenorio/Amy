import React from 'react';
import '../assets/css/navbar.css';

class Navbar extends React.Component {
    render() {
        return (
            <div>
                <nav id="navbar" className="navbar navbar-light">
                    <div className="row w-100">
                        <div className="col-6">
                            <a className="navbar-brand">Logo</a>
                        </div>
                        <div className="col-6">
                            <form className="form-inline">
                                <div className="col-3">
                                    <button id="btnCadastroNavbar" className="btn w-100">Cadastre-se!</button>
                                </div>
                                <div className="col-3">
                                    <button id="btnLoginNavbar" class="btn my-2 my-sm-0 w-100" type="submit">Login</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </nav>
            </div>
        )
    };
}

export default Navbar;
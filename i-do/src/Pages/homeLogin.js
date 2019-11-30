import React from 'react';
import '../assets/css/home.css';
import { Link } from 'react-router-dom';
import Navbar from '../components/navbar-home';

class HomeLogin extends React.Component {
    render() {
        return (
            <div>
                <Navbar/>
                <div id="content" className="justify-content-center mt-4">
                    <section name="start">
                        <div className="row w-100">
                            <div className="col-xl-6" align="center">
                                <h1 id="title">Vamos começar?</h1>
                                <div align="center">
                                    <p id="text">Explore o lugar perfeito para realizar seus serviços e gerenciá-los com facilidade.</p>
                                </div>
                            </div>
                            <div className="col-xl-6 p-3">
                                <div className="row">
                                    <Link to="/cadastroDeServico" className="col link">
                                        <div className="p-3 justify-content-center item-catalogo">
                                            <h4 class="link">Cadastre seus serviços</h4>
                                            <hr />
                                            <p class="link">Encontre quem precisa da sua ajuda e aumente seu portfólio. Dê o primeiro passo cadastrando seus serviços!</p>
                                        </div>
                                    </Link>
                                    <Link to="/meusServicos" className="col link">
                                        <div className="p-3 justify-content-center item-catalogo">
                                            <h4 class="link">Meus serviços</h4>
                                            <hr />
                                            <p class="link">Acesse seus serviços cadastrados no sistema e acompanhe os que já estão agendados.</p>
                                        </div>
                                    </Link>
                                </div>
                            </div>
                        </div>
                        <div className="row w-100 justify-content-center p-5" align="center">
                        </div>
                    </section>
                </div>
            </div>
        )
    }
}

export default HomeLogin
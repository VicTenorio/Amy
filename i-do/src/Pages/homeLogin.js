import React from 'react';
import '../assets/css/home.css';
import { Link } from 'react-router-dom';
import Navbar from '../components/navbar-home';

class HomeLogin extends React.Component {
    render() {
        return (
            <div id="body" style={{height: "150%", paddingBottom: "10%"}}>
                <Navbar />
                <div id="content" className="justify-content-center mt-4">
                    <section name="start">
                        <div className="row w-100 mb-4">
                            <div className="col-xl-6" align="center">
                                <h1 id="title">Vamos começar?</h1>
                                <div align="center">
                                    <p id="text">Explore o lugar perfeito para realizar seus serviços e gerenciá-los com facilidade.</p>
                                </div>
                            </div>
                            <div className="col-xl-6">
                                <div className="row caixas">
                                    <Link to="/cadastroDeServico" className="col link">
                                        <div className="p-3 justify-content-center item-catalogo">
                                            <h4 class="link">Cadastre seus serviços</h4>
                                            <hr />
                                            <p class="link">Dê o primeiro passo cadastrando seus serviços!</p>
                                        </div>
                                    </Link>
                                    <Link to="/meusServicos" className="col link">
                                        <div className="p-3 justify-content-center item-catalogo">
                                            <h4 class="link">Meus serviços</h4>
                                            <hr />
                                            <p class="link">Acesse seus serviços cadastrados no sistema.</p>
                                        </div>
                                    </Link>
                                </div>
                                <div className="row">
                                    <Link to="/servicosAgendados" className="col link">
                                        <div className="p-3 justify-content-center item-catalogo">
                                            <h4 class="link">Meus Agendamentos</h4>
                                            <hr />
                                            <p class="link">Veja quem se interessou pelos seus serviços!</p>
                                        </div>
                                    </Link>
                                    <Link to="" className="col link">
                                        <div className="p-4 justify-content-center item-catalogo">
                                            <h4 class="link">Sair</h4>
                                            <hr />
                                            <p class="link">Fazer o logoff da sua conta.</p>
                                        </div>
                                    </Link>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        )
    }
}

export default HomeLogin
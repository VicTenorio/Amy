import React from 'react';
import '../assets/css/home.css';
import Navbar from '../components/navbar-home';
import Footer from '../components/footer';
import { Link } from 'react-router-dom';

class Home extends React.Component {
    render() {
        return (
            <div>
                <div id="body">
                    <fragment>
                        <Navbar />
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
                                            <Link to="/cadastroDeServico" className="col">
                                                <div className="p-3 justify-content-center item-catalogo">
                                                    <h4>Cadastre seus serviços</h4>
                                                    <hr />
                                                    <p>Encontre quem precisa da sua ajuda e aumente seu portfólio. Dê o primeiro passo cadastrando seus serviços!</p>
                                                </div>
                                            </Link>
                                            <Link to="/meusServicos" className="col">
                                                <div className="p-3 justify-content-center item-catalogo">
                                                    <h4>Meus serviços</h4>
                                                    <hr />
                                                    <p>Acesse seus serviços cadastrados no sistema e acompanhe os que já estão agendados.</p>
                                                </div>
                                            </Link>
                                        </div>
                                    </div>
                                </div>
                                <div className="row w-100 justify-content-center p-5" align="center">
                                </div>
                            </section>
                        </div>
                    </fragment>
                </div>
                <section name="solution">
                    <div id="solution" align="center">
                        <div className="p-4">
                            <div>
                                <i id="light" className="fa fa-lightbulb-o display-1"></i>
                            </div>
                            <div>
                                <h1 className="display-4" id="meetSolution">Conheça nossas soluções</h1>
                            </div>
                            <div>
                                <h2 id="developedFor">Desenvolvidas para facilitar a conexão de prestadores e clientes</h2>
                            </div>
                        </div>
                        <div className="row w-100 justify-content-center p-5">
                            <div className="col">
                                <div id="iNeed">
                                    <h1 id="titleIneed" align="left">I need</h1>
                                    <p className="description">Para você que procura um lugar a fim de divulgar
                                        seu trabalho e encontrar quem precisa da sua ajuda.
                                    </p>
                                </div>
                            </div>
                            <div className="col ">
                                <div id="iDo">
                                    <h1 id="titleIdo" align="left">I do</h1>
                                    <p className="description">Para quem busca profissionais  que prestem um serviço eficiente
                                        com a facilidade que nosso app oferece.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <Footer />
            </div>
        )
    };
}

export default Home;
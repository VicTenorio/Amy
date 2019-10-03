import React from 'react';
import '../assets/css/home.css';
import Navbar from '../components/navbar-home';
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
                                <div className="justify-content-center mt-4">
                                    <div className="col-xl-12 p-3" align="center">
                                        <h1 id="title">Vamos começar?</h1>
                                    </div>
                                    <div align="center">
                                        <p id="text">Explore a variedade de serviços com a facilidade de divisão por categorias.</p>
                                    </div>
                                </div>
                                <div className="justify-content-center p-5" align="center">
                                    <div className="row w-100">
                                        <div className="col-xl-6">
                                            <div className="row">
                                                <Link to="#" className="p-1 col-3" align="center">
                                                    <div className="item-catalogo col">
                                                        <i class="fa fa-automobile display-1"></i>
                                                    </div>
                                                </Link>
                                                <Link to="#" className="p-1 col-3" align="center">
                                                    <div className="item-catalogo col">
                                                        <i class="fa fa-child display-1"></i>
                                                    </div>
                                                </Link>
                                                <Link to="#" className="p-1 col-3" align="center">
                                                    <div className="item-catalogo col">
                                                        <i class="fa fa-bathtub display-1"></i>
                                                    </div>
                                                </Link>
                                                <Link to="#" className="p-1 col-3" align="center">
                                                    <div className="item-catalogo col">
                                                        <i class="fa fa-code display-1"></i>
                                                    </div>
                                                </Link>
                                            </div>
                                        </div>
                                        <div className="col-xl-6">
                                            <div className="row">
                                                <Link to="#" className="p-1 col-3" align="center">
                                                    <div className="item-catalogo col">
                                                        <i class="fa fa-cog display-1"></i>
                                                    </div>
                                                </Link>
                                                <Link to="#" className="p-1 col-3" align="center">
                                                    <div className="item-catalogo col">
                                                        <i class="fa fa-cutlery display-1"></i>
                                                    </div>
                                                </Link>
                                                <Link to="#" className="p-1 col-3" align="center">
                                                    <div className="item-catalogo col">
                                                        <i class="fa fa-futbol-o display-1"></i>
                                                    </div>
                                                </Link>
                                                <Link to="#" className="p-1 col-3" align="center">
                                                    <div className="item-catalogo col">
                                                        <i class="fa fa-graduation-cap display-1"></i>
                                                    </div>
                                                </Link>
                                            </div>
                                        </div>
                                    </div>
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
                <section name="aboutUs">
                    <footer className="us row w-100">
                        <div className="col">
                            <p className="description mt-3 mb-5 p-5">Somos Amy! idealizada a contornar
                                as dificuldades de comunicação, organização e
                                tempo na hora de prestar serviços ou contratar um prestador
                                de modo ágil.
                            </p>
                        </div>
                        <div className="col">
                            <div className="social mt-3 mb-5 p-5">
                                <h1>Redes Socias</h1>
                                <i className="icons-social fa fa-facebook-square p-1"></i>
                                <i className="icons-social fa fa-instagram p-1"></i>
                                <i className="icons-social fa fa-linkedin-square p-1"></i>
                                <i className="icons-social fa fa-tumblr-square p-1"></i>
                            </div>
                        </div>
                    </footer>
                </section>
            </div>
        )
    };
}

export default Home;
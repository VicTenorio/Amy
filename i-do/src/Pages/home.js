import React from 'react';
import '../assets/css/home.css';
import Navbar from '../components/navbar-home';

class Home extends React.Component {
    render() {
        return (
            <div>
                <div id="body">
                    <fragment>
                        <Navbar />
                        <div id="content" className="justify-content-center mt-4">
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
                                            <div className="p-1 col-3" align="center">
                                                <div className="item-catalogo col ">
                                                    <i class="fa fa-child display-1"></i>
                                                </div>
                                            </div>
                                            <div className="p-1 col-3" align="center">
                                                <div className="item-catalogo col ">
                                                    <i class="fa fa-child display-1"></i>
                                                </div>
                                            </div>
                                            <div className="p-1 col-3" align="center">
                                                <div className="item-catalogo col ">
                                                    <i class="fa fa-child display-1"></i>
                                                </div>
                                            </div>
                                            <div className="p-1 col-3" align="center">
                                                <div className="item-catalogo col ">
                                                    <i class="fa fa-child display-1"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="col-xl-6">
                                        <div className="row">
                                            <div className="p-1 col-3" align="center">
                                                <div className="item-catalogo col ">
                                                    <i class="fa fa-child display-1"></i>
                                                </div>
                                            </div>
                                            <div className="p-1 col-3" align="center">
                                                <div className="item-catalogo col ">
                                                    <i class="fa fa-child display-1"></i>
                                                </div>
                                            </div>
                                            <div className="p-1 col-3" align="center">
                                                <div className="item-catalogo col ">
                                                    <i class="fa fa-child display-1"></i>
                                                </div>
                                            </div>
                                            <div className="p-1 col-3" align="center">
                                                <div className="item-catalogo col ">
                                                    <i class="fa fa-child display-1"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </fragment>
                </div>
                <div class="containeer" style={{marginTop: '-200px'}}>
                    <svg viewBox="0 0 500 500" preserveAspectRatio="xMinYMin meet">
                        <path d="M0,90 C150,25 350,150 500,80 L500,00 L0,0 Z" style={{ stroke: 'red', fill: 'white' }}></path>
                    </svg>
                </div>
                <div id="redonda" className="bg-warning" align="center">
                    <div>
                        <h1 id="meetSolution">Conheça nossas soluções</h1>
                    </div>
                    <div>
                        <h2 id="developedFor">Desenvolvidas para facilitar a conexão de prestadores e clientes</h2>
                    </div>
                    <div className="row justify-content-center">
                        <div id="iNeed" className="col-4">
                            <h1 id="titleIneed">I need</h1>
                        </div>
                        <div id="iDo" className="col-4">
                            <h1 id="titleIdo">I do</h1>
                        </div>
                    </div>
                </div>
            </div>
        )
    };
}

export default Home;
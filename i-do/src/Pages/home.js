import React from 'react';
import '../assets/css/home.css';
import Navbar from '../components/navbar-home';

class Home extends React.Component {
    render() {
        return (
            <div id="body">
                <fragment>
                    <Navbar />
                    <div id="content" className="justify-content-center mt-4">
                        <div className="justify-content-center">
                            <div className="col-xl-12" align="center">
                                <h1 id="title">Vamos começar?</h1>
                            </div>
                            <div className="col-xl-12 p-3" align="center">
                                <p id="text">Explore a variedade de serviços com a facilidade de divisão por categorias.</p>
                            </div>
                        </div>
                        <div className="justify-content-center" align="center">

                            <div className="row w-100">
                                <div className="col-xl-6">
                                    <div className="row">
                                        <div className="p-1 col-3" align="center">
                                            <div className="item-catalogo col bg-info">
                                                Aqui alguma categoria
                                        </div>
                                        </div>
                                        <div className="p-1 col-3" align="center">
                                            <div className="item-catalogo col bg-info">
                                                Aqui alguma categoria
                                        </div>
                                        </div>
                                        <div className="p-1 col-3" align="center">
                                            <div className="item-catalogo col bg-info">
                                                Aqui alguma categoria
                                        </div>
                                        </div>
                                        <div className="p-1 col-3" align="center">
                                            <div className="item-catalogo col bg-info">
                                                Aqui alguma categoria
                                        </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-xl-6">
                                    <div className="row">
                                        <div className="p-1 col-3" align="center">
                                            <div className="item-catalogo col bg-info">
                                                Aqui alguma categoria
                                        </div>
                                        </div>
                                        <div className="p-1 col-3" align="center">
                                            <div className="item-catalogo col bg-info">
                                                Aqui alguma categoria
                                        </div>
                                        </div>
                                        <div className="p-1 col-3" align="center">
                                            <div className="item-catalogo col bg-info">
                                                Aqui alguma categoria
                                        </div>
                                        </div>
                                        <div className="p-1 col-3" align="center">
                                            <div className="item-catalogo col bg-info">
                                                Aqui alguma categoria
                                        </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </fragment>
            </div>
        )
    };
}

export default Home;
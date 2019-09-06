import React from 'react';
import '../Css/home.css';

function Home() {
    return (
        <div id="body">
            <div id="content" className="row justify-content-center">
                <div className="row justify-content-center">
                    <div className="col-xl-12" align="center">
                        <h1 id="title">Vamos começar?</h1>
                    </div>
                    <div className="col-xl-12" align="center">
                        <p id="text">Explore a variedade de serviçoes com a facilidade de divisão por categorias.</p>
                    </div>
                </div>
                <div className="row">
                    <div className="col-xl-6">
                        <div className="row">
                            <div className="item-catalogo col-xl-2">
                                Aqui alguma categoria
                            </div>
                            <div className="item-catalogo col-xl-2">
                                Aqui alguma categoria
                            </div>
                            <div className="item-catalogo col-xl-2">
                                Aqui alguma categoria
                            </div>
                            <div className="item-catalogo col-xl-2">
                                Aqui alguma categoria
                            </div>
                        </div>
                    </div>
                    <div className="col-xl-6">
                        <div className="row">
                            <div className="item-catalogo col-xl-2">
                                Aqui alguma categoria
                            </div>
                            <div className="item-catalogo col-xl-2">
                                Aqui alguma categoria
                            </div>
                            <div className="item-catalogo col-xl-2">
                                Aqui alguma categoria
                            </div>
                            <div className="item-catalogo col-xl-2">
                                Aqui alguma categoria
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    );
}

export default Home;
import React from 'react';
import '../assets/css/home.css';

class Home extends React.Component {
    render() {
        return (
        <div id="body">
            <div id="content" className="justify-content-center">
                <div className="justify-content-center">
                    <div className="col-xl-12" align="center">
                        <h1 id="title">Vamos começar?</h1>
                    </div>
                    <div className="col-xl-12" align="center">
                        <p id="text">Explore a variedade de serviços com a facilidade de divisão por categorias.</p>
                    </div>
                </div>
                
                <div className="row">
                    <div className="col-xl-6">
                        <div className="row">
                            <div className="item-catalogo col bg-info" align="center">
                                Aqui alguma categoria
                            </div>
                            <div className="item-catalogo col bg-info" align="center">
                                Aqui alguma categoria
                            </div>
                            <div className="item-catalogo col bg-info" align="center">
                                Aqui alguma categoria
                            </div>
                            <div className="item-catalogo col bg-info" align="center">
                                Aqui alguma categoria
                            </div>
                        </div>
                    </div>
                    <div className="col-xl-6">
                        <div className="row">
                            <div className="item-catalogo col bg-info justify-content-center" align="center">
                                Aqui alguma categoria
                            </div>
                            <div className="item-catalogo col bg-info" align="center">
                                Aqui alguma categoria
                            </div>
                            <div className="item-catalogo col bg-info" align="center">
                                Aqui alguma categoria
                            </div>
                            <div className="item-catalogo col bg-info" align="center">
                                Aqui alguma categoria
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        )
    };
}

export default Home;
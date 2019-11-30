import React from 'react';
import Navbar from '../components/navbar-home';
import Footer from '../components/footer';
import iconIdea from '../assets/images/idea.png';
import HomeLogoff from '../Pages/homeLogoff';
import HomeLogin from  '../Pages/homeLogin';

class Home extends React.Component {
    render() {
        return (
            <div>
                <div id="body">
                    <fragment>
                        <HomeLogoff/>
                    </fragment>
                </div>
                <section name="solution">
                    <div id="solution" align="center">
                        <div className="p-4">
                            <div>
                                <img src={iconIdea}/>
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
                                    <h1 id="titleIneed" align="left">I do</h1>
                                    <p className="description">Para você que procura um lugar a fim de divulgar
                                        seu trabalho e encontrar quem precisa da sua ajuda.
                                    </p>
                                </div>
                            </div>
                            <div className="col">
                                <div id="iDo">
                                    <h1 id="titleIdo" align="left">I need</h1>
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
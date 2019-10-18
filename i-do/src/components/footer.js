import React from 'react';
import '../assets/css/footer.css'

class Footer extends React.Component {
    render() {
        return (
            <div>
                <footer className="us row w-100">
                    <div className="col">
                        <p className="description p-5">Somos Amy! idealizada a contornar
                            as dificuldades de comunicação, organização e
                            tempo na hora de prestar serviços ou contratar um prestador                                de modo ágil.
                        </p>
                    </div>
                    <div className="col">
                        <div className="social p-5">
                            <h1>Redes Socias</h1>
                                <i className="icons-social fa fa-facebook-square p-1"></i>
                                <i className="icons-social fa fa-instagram p-1"></i>
                                <i className="icons-social fa fa-linkedin-square p-1"></i>
                                <i className="icons-social fa fa-tumblr-square p-1"></i>
                        </div>
                    </div>
                </footer>
            </div>
        );
    }
}

export default Footer
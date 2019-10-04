import React from 'react';
import '../assets/css/serviceRegister.css';
import NavbarLogged from '../components/navbarLogged';

class ServiceRegister extends React.Component {
    render() {
        return (
            <div>
                <NavbarLogged />
                <label id="firstStep" className="phraseMotivation w-100" align="center">Dê os primeiros passo e cadastre seus serviços</label>
                <div className="">
                    <div className="col-xl-6" align="center">
                        <div className="row">
                            <div className="col justify-content-center">
                                <label className="row" align="center">Nome</label>
                                <input id="txtName" className="row" type="text" />
                            </div>
                            <div className="col">
                                <label className="row">Preço</label>
                                <input id="txtPrice" className="row" />
                            </div>
                        </div>
                        <div className="row w-100">
                            <label className="row w-100">Descrição</label>
                            <textarea id="txtDescription" className="row w-100" />
                        </div>
                        <label className="row">Local de atendimento</label>
                            <input type="radio" name="localAtendimento" />
                                Atendimento a domicílio
                            <input type="radio" name="localAtendimento" />
                                Atendimento no meu endereço
                        <div>

                        </div>
                    </div>
                    <div className="col-xl-6">

                    </div>
                </div>
            </div>
        )
    }
}

export default ServiceRegister;
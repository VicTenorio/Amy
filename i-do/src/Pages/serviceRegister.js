import React from 'react';
import '../assets/css/serviceRegister.css';
import NavbarLogged from '../components/navbarLogged';

class ServiceRegister extends React.Component {
    render() {
        return (
            <div>
                <NavbarLogged />
                <label id="firstStep" className="phraseMotivation w-100" align="center">Dê os primeiros passo e cadastre seus serviços</label>
                <div className="col-xl-7 ml-5 p-5">
                    <div className="row">
                        <div className="col">
                            <label className="row">Nome</label>
                            <input className="row w-100" type="text" />
                        </div>
                        <div className="col">
                            <label className="row">Preço</label>
                            <input className="row w-50" />
                        </div>
                    </div>
                    <div className="row">
                        <label className="row w-75">Descrição</label>
                        <textarea className="row w-75" />
                    </div>
                    <div className="row">
                        <label className="row w-100">Local de atendimento</label>
                        <div>
                            <input className="col" type="radio" name="localServico" />
                            <label className="col">Atendimento a domicílio</label>
                        </div>
                        <div>
                            <input className="col" type="radio" name="localServico" />
                            <label className="col">Atendimento no meu endereço</label>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col">
                            <label className="row">Estimativa de tempo</label>
                            <input className="row" type="text"/>
                        </div>
                        <div className="col">
                            <label className="row">Selecione a categoria</label>
                            <select className="row w-50">
                                <option value="Reformas">Reformas</option>
                                <option value="Culinária">Culinária</option>
                                <option value="Técnico">Técnico</option>
                                <option value="Eventos">Eventos</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ServiceRegister;
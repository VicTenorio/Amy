import React from 'react';
import '../assets/css/serviceRegister.css';
import NavbarLogged from '../components/navbarLogged';
import ServiceRequest from '../Requests/serviceRegisterRequest'
import uploadFile from '../Requests/uploadFile';

class ServiceRegister extends React.Component {
    render() {
        return (
            <div>
                <NavbarLogged />
                <label id="firstStep" className="w-100" align="center">Dê os primeiros passos e cadastre seus serviços</label>
                <div className="row w-100">
                    <div className="col-xl-7 ml-5 p-5">
                        <div className="row p-2">
                            <div className="col">
                                <label className="row">Nome</label>
                                <input id="txtName" className="row w-100" type="text" placeholder="Ex: Encanador" />
                            </div>
                            <div className="col">
                                <label className="row">Preço</label>
                                <input id="txtPrice" className="row w-50" placeholder="R$ 100,00"/>
                            </div>
                        </div>
                        <div className="row p-2">
                            <div className="col">
                                <label className="row w-75">Descrição</label>
                                <textarea id="txtDescription" className="row w-75" placeholder="Faço trabalhos de encanador, conserto pias"/>
                            </div>
                        </div>
                        <div className="col mt-2">
                            <label className="row">Local de atendimento</label>
                        </div>
                        <div className="row p-3">
                            <input type="radio" id="rd" name="localServico" value="domicilio" checked />
                            <label>Atendimento a domicílio</label>

                            <input type="radio" name="localServico" value="meuEndereco" />
                            <label>Atendimento no meu endereço</label>
                        </div>
                        <div className="row p-2">
                            <div className="col">
                                <label className="row">Estimativa de tempo</label>
                                <input id="txtTime" className="row" type="text" placeholder="2 horas" />
                            </div>
                            <div className="col">
                                <label className="row">Selecione a categoria</label>
                                <select id="categorias" className="row w-50">
                                    <option value="1">Auto</option>
                                    <option value="2">Tecnologia e Informática</option>
                                    <option value="3">Doméstico</option>
                                    <option value="4">Construção</option>
                                    <option value="5">Educação</option>]
                                    <option value="6">Entregas e Encomendas</option>
                                    <option value="7">Estética e Moda</option>
                                    <option value="8">Eventos, Música e Decorações</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div className="col-xl-4 p-5">
                        <div className="img-service">
                           
                            <label align="center" className="mt-2 w-100">Adicione uma foto</label>
                        <input type="file" id="fileInput" className="form-control" placeholder="Escolher arquivo" onChange={uploadFile}/>
                        <img id="foto" style={{maxWidth: '100%', maxHeight: '100%'}}></img>
                        </div>
                        <div className="row w-100 justify-content-center">
                            <button id="btnServiceRegister" className="mt-3 w-50" type="submit" onClick={ServiceRequest}>Cadastrar</button>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ServiceRegister;
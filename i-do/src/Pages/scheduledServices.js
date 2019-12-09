import React from 'react';
import Axios from 'axios'
import '../assets/css/scheduledServices.css';
import Navbar from '../components/navbarLogged';
import contract from '../Requests/ConnectionString';
import ModalServiceDetails from '../Pages/modalServiceDetails';

class ScheduledServices extends React.Component {

    state = {
        contrato: []
    };

    componentWillMount() {

        Axios.get(contract() + '/Prestador/Contratos?id=53' /*Prestador/Servicos?id=54*/)
            .then(Response => {
                console.log(Response.data)
                this.setState({ contrato: Response.data });
            })
            .catch(Error => {
                console.log("erro", Error)
            })
    }

    render() {
        return (
            <div>
                <Navbar />
                <label id="scheduleServices" className="w-100" align="center">Esses são os serviços que estão agendados</label>
                <div className="row w-100 p-3 justify-content-center border-bottom">
                    <div className="col-2">
                        <span>Filtros</span>
                    </div>
                    <div className="col-2">
                        <input type="text" placeholder="cidade" />
                    </div>
                    <div className="col-2">
                        <input type="text" placeholder="dia" />
                    </div>
                    <div className="col-2">
                        <input type="text" placeholder="horário" />
                    </div>
                    <div className="col-2">
                        <button id="applyFilter" type="submit" className="btn">Aplicar filtro</button>
                    </div>
                </div>
                {/* <label id="noRegister" className="w-100" align="center">Usuário, você ainda não possui serviços agendados.</label> */}
                {this.state.contrato.map(item => {
                    return (
                        <div className="row ml-1 mr-1 mt-4 " align="center">
                            <div className="cardContainer col-xl-3 col-lg-3 col-md-3 col-sm-10" align="center">
                                <label id="DayOfService">
                                    {item.dtAgendamento}
                                </label>
                                <hr />
                                <div className="p-3">
                                    <label className="row">
                                        Cliente: {item.consumidor.nome}
                                    </label>
                                    <label className="row">
                                        Telefone: {item.consumidor.telefone}
                                    </label>
                                    <label className="row">
                                        E-mail: {item.consumidor.email}
                                    </label>
                                </div>
                                <div>
                                    <input className="w-50" id="btnDetailsService" type="button" value="Analisar proposta" data-toggle="modal" data-target="#staticBackdrop" />
                                </div>
                                <div class="modal fade" id="staticBackdrop" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-centered" role="document">
                                        <div id="modalServiceDetails" class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title" id="exampleModalCenterTitle">Detalhes do serviço agendado</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <div className="p-2">
                                                    <div className="row">
                                                        <label className="dataClient">Cliente: </label>
                                                        <label>
                                                            <em>
                                                                {item.consumidor.nome}
                                                            </em>
                                                        </label>
                                                    </div>
                                                    <div className="row">
                                                        <label className="dataClient">Telefone: </label>
                                                        <label>
                                                            <em>
                                                                {item.consumidor.telefone}
                                                            </em>
                                                        </label>
                                                    </div>
                                                    <div className="row">
                                                        <label className="dataClient">E-mail: </label>
                                                        <label>
                                                            <em>
                                                                {item.consumidor.email}
                                                            </em>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div id="modalFooter">
                                                <div class="modal-footer justify-content-center" id="AproveButtons">
                                                    <input type="button" className="w-25" id="btnReprovar" data-dismiss="modal" value="Reprovar" />
                                                    <input type="button" className="w-25" id="btnAprovar" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample" value="Aprovar" />
                                                </div>
                                            </div>
                                            <div class="collapse" id="collapseExample">
                                                <div class="card card-body">
                                                    <label>
                                                        Você tem certeza que quer confirmar este agendamento?
                                                </label>
                                                    <div className="justify-content-center row w-100">
                                                        <input type="button" className="col-xl-4" id="btnRate" data-toggle="collapse" data-target="#collapseExample" value="Avaliar melhor" />
                                                        <input type="button" className="col-xl-4" id="btnConfirm" data-toggle="modal" data-target=".bd-example-modal-sm" value="Confirmar!" />
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    )
                })}
            </div>
        )
    }
}

export default ScheduledServices
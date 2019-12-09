import React from 'react';
import Axios from 'axios';
import NavbarLogged from '../components/navbarLogged';
import '../assets/css/my-services.css';
import service from '../Requests/ConnectionString';

class MyServices extends React.Component {

    state = {
        servico: []
    };

    componentWillMount() {
        
        Axios.get(service() + 'Prestador/Servicos?id=54')
            .then(Response => {
                console.log(Response.data)
                this.setState({servico: Response.data});
            })
            .catch(Error => {
                console.log("erro", Error)
            })
    }

    render() {
        return (
            <div>
                <fragment>
                    <NavbarLogged />
                    <label id="yourServices" className="w-100" align="center">Aqui estão seus serviços cadastrados</label>
                    <label id="noRegister" className="w-100" align="center">Usuário, você ainda não possui serviços cadastrados.</label>
                    {this.state.servico.map(item => {
                        return (
                            <div className="p-4">
                                <div className="cardContainer col-xl-3 col-lg-3 col-md-3 col-sm-10">
                                    <div className="border h-50" >
                                      <img src="#" alt="imgService" src={`data:image/jpeg;base64,${item.imagem[0].image}`} style={{maxWidth: '100%', maxHeight: '20%'}} />
                                    </div>
                                    <label id="ServiceName">
                                       {item.nome}
                                    </label>
                                    <label id="ServiceDescription">
                                        {item.descricao}
                                    </label><br />
                                    <hr />
                                    <strong id="ServicePrice">
                                        R${item.preco}
                                    </strong>
                                    <div className="row p-2">
                                        <div className="col-6">
                                            <input className="w-100" type="button" id="btnDeleteService" value="Excluir" />
                                        </div>
                                        <div className="col-6">
                                            <input className="w-100" type="button" id="btnEditService" value="Editar" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        )
                    })}
                </fragment>
            </div>
        )
    }
}

export default MyServices
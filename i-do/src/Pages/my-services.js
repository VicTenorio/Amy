import React from 'react';
import Axios from 'axios';
import NavbarLogged from '../components/navbarLogged';
import '../assets/css/my-services.css';
import CardMyServices from '../components/cardMyServices';
import { getAllByUser } from '../Models/ModelService';
import cardMyServices from '../components/cardMyServices';

class MyServices extends React.Component {

    state = {
        servico: []
    };

    componentWillMount() {
        
        Axios.get('https://ravenamy.azurewebsites.net/Prestador/Servicos?id=882')
            .then(Response => {
                console.log(Response)
                this.setState.servico = Response;
            })
            .catch(Error => {
                console.log(Error)
            })
    }

    render() {
        return (
            <div>
                <fragment>
                    <NavbarLogged />
                    <label id="yourServices" className="w-100" align="center">Aqui estão seus serviços cadastrados</label>
                    <label id="noRegister" className="w-100" align="center">Usuário, você ainda não possui serviços cadastrados.</label>
                    {Object.keys(this.state.servico).map((item) => {
                        return (
                            <cardMyServices
                                key={item}
                                servico={this.state.servico[item]}
                            />
                        )
                    })}
                </fragment>
            </div>
        )
    }
}

export default MyServices
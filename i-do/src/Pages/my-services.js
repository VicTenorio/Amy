import React from 'react';
import Axios from 'axios';
import NavbarLogged from '../components/navbarLogged';
import '../assets/css/my-services.css';
import CardMyServices from '../components/cardMyServices';
import {getAllByUser} from '../Models/ModelService';

class MyServices extends React.Component {

    state = {
        servico: []
    };

    componentWillMount() {
      
        Axios.get('https://ravenamy.azurewebsites.net/Prestador/Servicos')
            .then(Response => {
                console.log(Response)
                this.state.servico = Response;
            })
            .catch(Error => {
                console.log(Error)
            })
    }
   
    render() {
        return (
            <div>
                <fragment>
                    <NavbarLogged/>
                    <label id="yourServices" className="w-100" align="center">Aqui estão seus serviços cadastrados</label>
                    {/* <label id="noRegister" className="w-100" align="center">Usuário, você ainda não possui serviços cadastrados.</label> */}
                   {this.state.servico.map((servico) => 
                    <CardMyServices servico={servico} />
                   )
                }
                </fragment>
            </div>
        )
    }
}

export default MyServices
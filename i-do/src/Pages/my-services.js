import React from 'react';
import NavbarLogged from '../components/navbarLogged';
import '../assets/css/my-services.css';
import CardMyServices from '../components/cardMyServices';
import {getAllByUser} from '../Models/ModelService';

class MyServices extends React.Component {

    componentWillMount(){
        const servico = getAllByUser(165);
        console.log(servico);
    }
   
    render() {
        return (
            <div>
                <fragment>
                    <NavbarLogged/>
                    <label id="yourServices" className="w-100" align="center">Aqui estão seus serviços cadastrados</label>
                    {/* <label id="noRegister" className="w-100" align="center">Usuário, você ainda não possui serviços cadastrados.</label> */}
                    <CardMyServices/>
                </fragment>
            </div>
        )
    }
}

export default MyServices
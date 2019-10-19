import React from 'react';
import NavbarLogged from '../components/navbarLogged';
import '../assets/css/my-services.css';

class MyServices extends React.Component {
    render() {
        return (
            <div>
                <fragment>
                    <NavbarLogged/>
                    <label id="yourServices" className="w-100" align="center">Aqui estão seus serviços cadastrados</label>
                    <label id="noRegister" className="w-100" align="center">Usuário, você ainda não possui serviços cadastrados.</label>
                </fragment>
            </div>
        )
    }
}

export default MyServices
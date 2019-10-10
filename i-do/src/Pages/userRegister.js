import React from 'react';
import '../assets/css/serviceRegister.css';
import NavbarRegister from '../components/navbar-register';
import { cep } from './apiCorreios';

class userRegister extends React.Component {
    render() {
        return (
            <div>
            <NavbarRegister />
            <input id='cep' placeholder='cep'/>
            <input id='rua' placeholder='rua'/>
            <input id="bairro" placeholder='bairro'/>
            <button onClick={cep(document.getElementById("cep"))}>eu</button>
            </div>
        )
    }
}
    
export default userRegister;
import React from 'react';
import {Link} from 'react-router-dom';
import NavbarLogged from '../components/navbarLogged';
import '../assets/css/my-services.css';

class MyServices extends React.Component {
    render() {
        return (
            <div>
                <fragment>
                    <NavbarLogged/>
                    <label id="yourServices" className="w-100" align="center">Aqui estão seus serviços cadastrados</label>
                    <div className="row w-100 p-3 justify-content-center border-bottom">
                         <div className="col-2">
                            <span>Filtros</span>
                         </div>
                         <div className="col-2">
                            <input type="text" placeholder="cidade"/>
                         </div>
                         <div className="col-2">
                            <input type="text" placeholder="dia"/>
                         </div>
                         <div className="col-2">
                             <input type="text" placeholder="horário"/>
                         </div>
                         <div className="col-2">
                             <Link to="/">
                                <span>Voltar para o início</span>
                             </Link>
                         </div>
                    </div>
                </fragment>
            </div>
        )
    }
}

export default MyServices
import React from 'react';
import '../assets/css/scheduledServices.css';
import Navbar from '../components/navbarLogged'

class ScheduledServices extends React.Component {
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
                <label id="noRegister" className="w-100" align="center">Usuário, você ainda não possui serviços agendados.</label>
            </div>
        )
    }
}

export default ScheduledServices
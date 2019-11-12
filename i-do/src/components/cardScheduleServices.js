import React from 'react';
import '../assets/css/cardScheduleServices.css'

class cardScheduleServices extends React.Component {
    render() {
        return (
            <div className="p-4">
                <div className="cardContainer col-xl-3 col-lg-3 col-md-3 col-sm-10" align="center">
                    <label id="DayOfService">26/10</label>
                    <hr />
                    <div className="p-3">
                        <label className="row">Cliente: Marcia Silva</label>
                        <label className="row">Horário: 14:00h</label>
                        <label className="row">Local: Av. Paulista, 535</label>
                    </div>
                    <div>
                        <input className="w-50" id="btnDetailsService" type="button" value="Mais detalhes" />
                    </div>
                </div>
            </div>
        )
    }
}

export default cardScheduleServices;
import React from 'react';
import '../assets/css/cardMyservices.css';

class cardMyServices extends React.Component {

    state = {
        servico: []
    };

    constructor(servico) {
        super();
        this.state.servico = servico;
    }

    render() {
        return (
            <div className="p-4">
                <div className="cardContainer col-xl-3 col-lg-3 col-md-3 col-sm-10">
                    <div className="border h-50">
                        <img src="#" alt="imgService" />
                    </div>
                    <label id="ServiceName">
                        {console.log(this.state.servico.nome)}
                    </label>
                    <label id="ServiceDescription">
                        {console.log(this.state.servico.descricao)}
                    </label><br />
                    <hr />
                    <strong id="ServicePrice">
                        {console.log(this.state.servico.preco)}
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
    }
}

export default cardMyServices
import React from 'react';
import '../assets/css/cardMyservices.css';

class cardMyServices extends React.Component {


    render() {
        return (
            <div className="p-4">
                <div className="cardContainer col-xl-3 col-lg-3 col-md-3 col-sm-10">
                    <div className="border h-50">
                        <img src="#" alt="imgService" />
                    </div>
                    <label id="ServiceName">
                       
                    </label>
                    <label id="ServiceDescription">
                        {this.props.item.nome}
                    </label><br />
                    <hr />
                    <strong id="ServicePrice">
                        {this.props.item.preco}
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
import React from 'react';
import '../assets/css/userRegister.css';
import NavbarRegister from '../components/navbar-register';
import { cep } from './apiCorreios';

class userRegister extends React.Component {
    render() {
        return (
            <div>
                <NavbarRegister />
                <form>
                    <div class="row title-register">
                        <p>Dados Pessoais</p>
                    </div>
                    <div className="row">
                        <div class="row w-100">
                            <p class="txt-input">Nome</p>
                        </div>
                        <div class="row w-100">
                            <input class="input-name" />
                        </div>
                    </div>
                    <div className="row">
                        <div class="col-4 w-100">
                            <p class="txt-input">RG</p>
                            <input class="input-inp" />
                        </div>
                        <div class="col-4 w-100">
                            <p class="txt-input" style={{ marginLeft: '18%'}}>CPF</p>
                            <input class="input-inp" style={{ marginLeft: '18%'}} />
                        </div>
                    </div>
                    <div className="row">
                        <div class="col-4 w-100">
                            <p class="txt-input">Data de Nascimento</p>
                            <input class="input-inp" />
                        </div>
                        <div class="col-4 w-100">
                            <p class="txt-input" style={{ marginLeft: '18%'}}>Estado Civil</p>
                            <div class="dropdown">
                                <button class="btn input-btn dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Selecione
                                </button>
                            <div class="dropdown-menu w-100" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="#">Solteiro(a)</a>
                                <a class="dropdown-item" href="#">Casado(a)</a>
                                <a class="dropdown-item" href="#">Divorciado(a)</a>
                                <a class="dropdown-item" href="#">Viuva(a)</a>
                            </div>
                            </div>
                        </div>
                    </div>
                    <div className="row">
                    <div class="row w-100">
                        <p class="txt-input">Sexo</p>
                    </div>
                    <div class="row w-100">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" checked/>
                        <label class="form-check-label">
                            Feminino
                        </label>
                    </div>
                    </div>
                    </div>
                    <div class="row title-register">
                        <p>Dados de Acesso e Contato</p>
                    </div>
                    <div class="row">
                        <div class="col-5">
                            <p class="txt-input">Email</p>
                        </div>
                        <div class="col-5">
                            <p class="txt-input">Telefone</p>
                        </div>
                    </div>
                    <div class="row w-100">
                        <div class="col-5">
                            <input class="input-meio" />
                        </div>
                        <div class="col-5">
                            <input class="input-meio" />
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-5">
                            <p class="txt-input">Senha</p>
                        </div>
                        <div class="col-5">
                            <p class="txt-input">Confirmar senha</p>
                        </div>
                    </div>
                    <div class="row w-100">
                        <div class="col-5">
                            <input class="input-meio" />
                        </div>
                        <div class="col-5">
                            <input class="input-meio" />
                        </div>
                    </div>

                    <div class="row title-register">
                        <p>Endereço</p>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <p class="txt-input">Rua</p>
                        </div>
                        <div class="col-2 ml-5">
                            <p class="txt-input">Número</p>
                        </div>
                    </div>
                    <div class="row w-100">
                        <div class="col-6">
                            <input class="input-rua" />
                        </div>
                        <div class="col-2">
                            <input class="input-number" />
                        </div>
                    </div>
                    <div class="row w-100">
                        <p class="txt-input">Referência</p>
                    </div>
                    <div class="row w-100">
                        <div class="col-9">
                            <input class="input-inp" />
                        </div>
                    </div>
                    <div class="row w-100">
                        <p class="txt-input">Complemento</p>
                    </div>
                    <div class="row w-100">
                        <div class="col-9">
                            <input class="input-inp" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-5">
                            <p class="txt-input">CEP</p>
                        </div>
                        <div class="col-5">
                            <p class="txt-input">Bairro</p>
                        </div>
                    </div>
                    <div class="row w-100">
                        <div class="col-5">
                            <input class="input-meio" />
                        </div>
                        <div class="col-5">
                            <input class="input-meio" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-5">
                            <p class="txt-input">Cidade</p>
                        </div>
                        <div class="col-5">
                            <p class="txt-input">Estado</p>
                        </div>
                    </div>
                    <div class="row w-100">
                        <div class="col-5">
                            <input class="input-meio" />
                        </div>
                        <div class="col-5">
                            <input class="input-meio" />
                        </div>
                    </div>
                    <div class="row btn-wrapper">
                        <button class='btn-cadastrar'>Cadastrar</button>
                    </div>
                    <div class="footer-register">

                    </div>

                </form>
            </div>
        )
    }
}

export default userRegister;
import React from 'react';
import '../assets/css/userRegister.css';
import NavbarRegister from '../components/navbar-register';
import Cep from '../Pages/apiCorreios';
import UserRequest from '../Requests/userRequest'
import uploadFile from '../Requests/uploadFile';

class userRegister extends React.Component {
    render() {
        return (
            <div>
                <NavbarRegister />
                <div className="w-100 p-2">
                    <div class="row title-register w-100">
                        <p>Dados Pessoais</p>
                    </div>
                    <div class="fotoupload w-100">
                        <img id="foto"></img>
                        <input id="fileInput" type="file" placeholder="Escolher arquivo" onChange={uploadFile} />
                    </div>
                    <div className="row w-100">
                        <div class="row w-100">
                            <p class="txt-input">Nome</p>
                        </div>
                        <input id="txtNome" class="input-name" />
                    </div>
                    <div className="row w-100 p-2">
                        <div class="col-4 w-100">
                            <p class="txt-input">RG</p>
                            <input id="txtRg" class="input-inp" />
                        </div>
                        <div class="col-4 w-100">
                            <p class="txt-input" style={{ marginLeft: '18%' }}>CPF</p>
                            <input id="txtCpf" class="input-inp" style={{ marginLeft: '18%' }} />
                        </div>
                    </div>
                    <div className="row w-100 p-2">
                        <div class="col-4 w-100">
                            <p class="txt-input">Data de Nascimento</p>
                            <input id="txtDataNascimento" class="input-inp" />
                        </div>
                        <div class="col-4 w-100">
                            <p class="txt-input" style={{ marginLeft: '18%' }} >Estado Civil</p>
                            <select className="w-100 h-50" id="estadoCivil" style={{ marginLeft: '18%' }} >
                                <option value="solteiro">Solteiro(a)</option>
                                <option value="casado">Casado(a)</option>
                                <option value="divorciado">Divorciado(a)</option>
                                <option value="viuvo">Viuva(a)</option>
                            </select>
                        </div>
                    </div>
                    <div className="row w-100 p-2">
                        <div class="row w-100">
                            <p class="txt-input">Sexo</p>
                        </div>
                        <div class="row w-50 p-3">
                            <div className="col-xl-5 ml-4">
                                <input class="form-check-input" name="sexo" type="radio" value="F" />
                                <label>Feminino</label>
                            </div>
                            <div className="col-xl-5">
                                <input class="form-check-input" name="sexo" type="radio" value="M" />
                                <label>Masculino</label>
                            </div>
                        </div>
                        <div class="fotoupload w-100">
                            <img id="fotoDocument"></img>
                            <input id="fileDoc" type="file" placeholder="Escolher arquivo"/>
                        </div>
                    </div>
                </div>
                <div className="w-100 p-2">
                    <div class="row w-100 title-register">
                        <p>Dados de Acesso e Contato</p>
                    </div>
                    <div class="row w-100">
                        <div class="col-5">
                            <p class="txt-input">Email</p>
                        </div>
                        <div class="col-5">
                            <p class="txt-input">Telefone</p>
                        </div>
                    </div>
                    <div class="row w-100">
                        <div class="col-5">
                            <input id="txtEmail" class="input-meio" />
                        </div>
                        <div class="col-5">
                            <input id="txtTelefone" class="input-meio" />
                        </div>
                    </div>

                    <div class="row w-100">
                        <div class="col-5">
                            <p class="txt-input">Senha</p>
                        </div>
                        <div class="col-5">
                            <p class="txt-input">Confirmar senha</p>
                        </div>
                    </div>
                    <div class="row w-100">
                        <div class="col-5">
                            <input id="txtSenha" type="password" class="input-meio" />
                        </div>
                        <div class="col-5">
                            <input type="password" class="input-meio" />
                        </div>
                    </div>
                </div>

                <div className="w-100 p-2">
                    <div class="row w-100 title-register">
                        <p>Endereço</p>
                    </div>
                    <div class="row w-100">
                        <div class="col-5">
                            <p class="txt-input">CEP</p>
                        </div>
                        <div class="col-5">
                            <p class="txt-input">Bairro</p>
                        </div>
                    </div>
                    <div class="row w-100">
                        <div class="col-5">
                            <input id="txtCep" class="input-meio" />
                            <input type="button" id="findCep" value="Buscar" onClick={Cep} />
                        </div>
                        <div class="col-5">
                            <input id="txtBairro" class="input-meio" />
                        </div>
                    </div>
                    <div class="row w-100">
                        <div class="col-6">
                            <p class="txt-input">Rua</p>
                        </div>
                        <div class="col-2 ml-5">
                            <p class="txt-input">Número</p>
                        </div>
                    </div>
                    <div class="row w-100">
                        <div class="col-6">
                            <input id="txtRua" class="input-rua" />
                        </div>
                        <div class="col-2">
                            <input id="txtNumero" class="input-number" />
                        </div>
                    </div>
                    <div class="row w-100">
                        <div class="col-5">
                            <p class="txt-input">Cidade</p>
                        </div>
                        <div class="col-5">
                            <p class="txt-input">Estado</p>
                        </div>
                    </div>
                    <div class="row w-100">
                        <div class="col-5">
                            <input id="txtCidade" class="input-meio" />
                        </div>
                        <div class="col-5">
                            <input id="txtEstado" class="input-meio" />
                        </div>
                    </div>
                    <div class="row w-100">
                        <p class="txt-input">Referência</p>
                    </div>
                    <div class="row w-100">
                        <div class="col-9">
                            <input id="txtReferencia" class="input-inp" />
                        </div>
                    </div>
                    <div class="row w-100">
                        <p class="txt-input">Complemento</p>
                    </div>
                    <div class="row w-100">
                        <div class="col-9">
                            <input id="txtComplemento" class="input-inp" />
                        </div>
                    </div>
                    <div class="btn-wrapper">
                        <button class='btn-cadastrar' onClick={UserRequest}>Cadastrar</button>
                    </div>
                </div>
                <div class="w-100 footer-register">

                </div>
            </div>
        )
    }
}

export default userRegister;
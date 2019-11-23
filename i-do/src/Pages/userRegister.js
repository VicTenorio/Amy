import React from 'react';
import '../assets/css/userRegister.css';
import NavbarRegister from '../components/navbar-register';
import Cep from '../Pages/apiCorreios';
import Request from '../Requests/userRequest'

class userRegister extends React.Component {
    render() {
        return (
            <div>
                <NavbarRegister />
                <div class="row title-register">
                    <p>Dados Pessoais</p>
                </div>
                <div className="row">
                    <div class="row w-100">
                        <p class="txt-input">Nome</p>
                    </div>
                    <div class="row w-100">
                        <input id="txtNome" class="input-name" />
                    </div>
                </div>
                <div className="row">
                    <div class="col-4 w-100">
                        <p class="txt-input">RG</p>
                        <input id="txtRg" class="input-inp" />
                    </div>
                    <div class="col-4 w-100">
                        <p class="txt-input" style={{ marginLeft: '18%' }}>CPF</p>
                        <input id="txtCpf" class="input-inp" style={{ marginLeft: '18%' }} />
                    </div>
                </div>
                <div className="row">
                    <div class="col-4 w-100">
                        <p class="txt-input">Data de Nascimento</p>
                        <input id="txtDataNascimento" class="input-inp" />
                    </div>
                    <div class="col-4 w-100">
                        <p class="txt-input" style={{ marginLeft: '18%' }}>Estado Civil</p>
                        <select id="estadoCivil">
                            <option value="solteiro">Solteiro(a)</option>
                            <option value="casado">Casado(a)</option>
                            <option value="divorciado">Divorciado(a)</option>
                            <option value="viuvo">Viuva(a)</option>
                        </select>
                    </div>
                </div>
                <div className="row">
                    <div class="row w-100">
                        <p class="txt-input">Sexo</p>
                    </div>
                    <div class="row p-3">
                        <input class="form-check-input" name="sexo" type="radio" value="F" />
                        <label>Feminino</label>

                        <input class="form-check-input ml-5" name="sexo" type="radio" value="M" />
                        <label>Masculino</label>
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
                        <input id="txtEmail" class="input-meio" />
                    </div>
                    <div class="col-5">
                        <input id="txtTelefone" class="input-meio" />
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
                        <input id="txtSenha" class="input-meio" />
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
                        <input id="txtRua" class="input-rua" />
                    </div>
                    <div class="col-2">
                        <input id="txtNumero" class="input-number" />
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
                        <input id="txtCep" class="input-meio" />
                        <input type="button" id="findCep" value="Buscar" onClick={Cep}/>
                    </div>
                    <div class="col-5">
                        <input id="txtBairro" class="input-meio" />
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
                        <input id="txtCidade" class="input-meio" />
                    </div>
                    <div class="col-5">
                        <input id="txtEstado" class="input-meio" />
                    </div>
                </div>
                <div class="row btn-wrapper">
                    <button class='btn-cadastrar' onClick={Request}>Cadastrar</button>
                </div>
                <div class="footer-register">

                </div>
            </div>
        )
    }
}

export default userRegister;
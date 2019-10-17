const sql = require("mssql")
var config = require("../models/connection");

module.exports = class Usuario {

    constructor(idUsuario,
        nome,
        email,
        CpfCnpj,
        RG,
        telefone,
        senha,
        prestador,
        sexo,
        estadoCivil,
        dataNascimento,
        idEndereco, ) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.CpfCnpj = CpfCnpj;
        this.RG = RG;
        this.telefone = telefone;
        this.senha = senha;
        this.prestador = prestador;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.dataNascimento = dataNascimento;
        this.idEndereco = idEndereco;

    }


    selectAll(res) {
        const userList = [];
        sql.connect(config).then(() => {
            return sql.query`select * from usuario`
        }).then(resultado => {            
            resultado.recordset.forEach(x =>{                                    
                const user = new Usuario();
                user.idUsuario = x["id_usuario"].toString();
                user.RG = x["rg"];
                user.CpfCnpj =  x["cpf_cnpj"];
                user.dataNascimento = x["data_nascimento"];
                user.email = x["email"];
                user.estadoCivil = x["estado_civil"];
                user.nome = x["nome"];
                user.prestador = x["prestador"];
                user.senha = x["senha"];
                user.sexo = x["sexo"];
                user.telefone = x["telefone"];
                userList.push(user);
            });
            res.send(user);
        }).catch(err => {
            res.json(err);
        })

        sql.close();
    }

    login(email, senha, res) {
        sql.connect(config).then(async () => {
            var resultado = await sql.query`select * from usuario where email = ${email} and senha = ${senha}`
            
            const user = new Usuario();
            resultado.recordset.forEach(x =>{                                    
                user.idUsuario = x["id_usuario"].toString();
                user.RG = x["rg"];
                user.CpfCnpj =  x["cpf_cnpj"];
                user.dataNascimento = x["data_nascimento"];
                user.email = x["email"];
                user.estadoCivil = x["estado_civil"];
                user.nome = x["nome"];
                user.prestador = x["prestador"];
                user.senha = x["senha"];
                user.sexo = x["sexo"];
                user.telefone = x["telefone"];
            });
            sql.close();
            res.send(user);
        })
            .catch(err => {
                res.json(err);
                console.log("eroooo");
            })
    }
}
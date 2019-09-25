var Conn = require("../models/connection");
var conn = new Conn();

module.exports = class Usuario {
    constructor(_email,_senha) {
        this.email = _email;
        this.senha = _senha;
    }

    
    save() {
        var usuario = [
            {
              email: this.email, 
              senha: this.senha
            },
            {
              email: "teste@2",
              senha: "senha123"
            },
            {
              email: "teste@3", 
              senha: "senha123"
            }
        ];
        return JSON.stringify(usuario);
    }

    selectAll(res){
        var sqlQry = "select * from usuarios;"
        conn.connection().query(sqlQry, function(err, results, fields){
            if(err) res.json(err);
            else return res.json(results);
            connection.end();                    
        })
    }

    selectById(id,res){
        var sqlQry = "select * from usuarios where id = " + id;
        conn.connection().query(sqlQry, function(err, results, fields){
            if(err) res.json(err);
            else return res.json(results);
            connection.end();
        })
    }

    insertUser(email,senha,res){
        var sqlQry = "insert into usuarios (email,senha) values ('"+email+"','"+senha+"');";
        conn.connection().query(sqlQry, function(err, results, fields){
            if(err) res.json(err);
            else return res.json(results);
            connection.end();
        })
    }

    updateUser(id,email,senha,res){
        var sqlQry = "update usuarios set email ='"+email+"', senha = '"+senha+"'"+
        " where id = "+id;

        conn.connection().query(sqlQry,function(err, results, fields){
            if(err) res.json(err);
            else return res.json(results);
            connection.end();
        })
    }

    deleteUser(id,res){
        var sqlQry = "delete from usuarios where id = " + id;
        conn.connection().query(sqlQry, function(err, results, fields){
            if(err) res.json(err);
            else return res.json(results);
            connection.end();
        })
    }

    login(email,senha,res){
        var sqlQry = "select * from usuarios where email = '"+email+"' and senha = '"+senha+"';"

        conn.connection().query(sqlQry, function(err, results, fields){
            if(err) res.json(err);
            else return res.json(results);
            connection.end();
        })
    }
}
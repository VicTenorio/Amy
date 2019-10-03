const sql = require("mssql")
var config = require("../models/connection");

module.exports = class Usuario {

    selectAll(res){
        
        sql.connect(config).then(() => {
            return sql.query`select * from usuario`
        }).then(result => {
            res.json(result);
        }).catch(err => {
            res.json(err);
        })

        sql.close();
        //return connect(query,call => {console.log(call.recordset)});
    }

    login(email,senha,res){
        sql.connect(config).then(async () => {
            var resultado = await sql.query`select * from usuario where email = ${email} and senha = ${senha}`
            console.log(">>>"+email);
            return res.json(resultado);            
        })
        .catch(err => {
            res.json(err);
            console.log("eroooo");
        })

        //sql.close();
        //return connect(query,call => {console.log(call.recordset)});
    }
/*
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
    }*/
}
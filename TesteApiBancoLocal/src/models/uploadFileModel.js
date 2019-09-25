var Conn = require("../models/connection");
var conn = new Conn();

module.exports = class UploadFile {
    constructor(_email,_senha) {
        this.email = _email;
        this.senha = _senha;
    }
    /*
    Parametros:
        -id do usuário
        -caminho do documento
    */ 
    //pegar id da variavel de ambiente
    insertDocument(id, path, res){
        var sqlQry = "insert into uploadFiles (path, id_usuario) values ('"+path+"',"+id+")";
        conn.connection().query(sqlQry, function(err, results, fields){
            //if(err) res.json(err);
            //else return res.json(results);
            conn.connection().end();
        });
    }
}
const mysql = require("mysql");

function execSQLQuery(sqlQry, res){
    const connection = mysql.createConnection({
        host: 'localhost',
        user: 'root',
        password: 'root',
        database: 'test',  
    })


    connection.connect(sqlQry, function(err, results, fields){
        if(err) res.json(err);
        else res.json(results);
        connection.end();
        console.log('conectou');                    
    })
}

function createTable(conn){

    const sql = "CREATE TABLE IF NOT EXISTS USUARIOS ("+
                "ID int primary key not null auto_increment,"+
                "EMAIL varchar(50),"+
                "SENHA varchar(50));"

    conn.query(sql, function (error, results, fields){
        if(error) return console.log(error);
        console.log("criou a tablea");
    })

    addRows(conn);
}



function addRows(conn){

    const sql = "INSERT INTO USUARIOS(EMAIL, SENHA) values ?"
    const values =  [
        ['email@email','senha123'],
        ['teste@teste','senha412'],
        ['outroTteste@teste','outrasenha']
    ];

    conn.query(sql,[values], function(error, results, fields){
        if(error) return console.log(error);
        console.log("adicionou registros!!!");
        conn.end();//fecha conexão
    })
};


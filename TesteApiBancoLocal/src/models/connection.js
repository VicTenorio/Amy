const mysql = require("mysql")
module.exports = class Conn {

    connection() {
        const connection = mysql.createConnection({
            host: 'localhost',
            user: 'root',
            password: 'root',
            database: 'test',  
        })

        return connection;
    }

}



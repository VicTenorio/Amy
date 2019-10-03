const dataBase = require("./connection");


dataBase("SELECT * FROM USUARIO", res => {console.log(res.recordset)});

const mssql = require("mssql")


const config = {
    user: '',
    password: '',
    server: '',
    database: '',
    options: {
        encrypt: true
    }
};

const connect = async (query, call) => {
    try {
        await mssql.connect(config);
        let result = await mssql.query(query);
        mssql.close();
        call(result);        
    } catch (error) {
        call(error);
        throw error;
    }
    
}

module.exports = connect;

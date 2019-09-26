const mssql = require("mssql")


const config = {
    user: 'placebo',
    password: 'info@211',
    server: 'bosco.database.windows.net',
    database: 'musical',
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

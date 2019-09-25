const express = require('express');
const bodyParser = require('body-parser');
const app = express();

//permitindo que recebamos mais tarde POSTs nos formatos URLEncoded e JSON
app.use(bodyParser.urlencoded({
    extended: true
}));
app.use(bodyParser.json());


//Rotas
const index = require('./routes/index');
const personRoute = require('./routes/personRoute');
const mapsRoute = require('./routes/mapsRoute');
const usuarioRoute = require('./routes/usuarioRoute');


//teste upload documentos
const uploadFile = require('./routes/uploadFile');
app.use(express.static('src/view'));
app.use('/profile', uploadFile);

app.use('/', index);
app.use('/persons', personRoute);
app.use('/maps',mapsRoute);
app.use('/usuario',usuarioRoute);


module.exports = app;
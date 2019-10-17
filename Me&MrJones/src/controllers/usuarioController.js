var Maps = require('../models/mapsModel');
var Conn = require('../models/connection');
var Usuario = require('../models/usuarioModel');

 exports.selectAll = (req,res,next)=>{    
    new Usuario().usuario.selectAll((result)=>{
        res.send(result);
    });
 }

 exports.login = (req, res, next) => {    
    const email = req.body.email;
    const senha = req.body.senha;
    const user = new Usuario().login(email,senha,(result)=>{
        res.send(result);
    });
}
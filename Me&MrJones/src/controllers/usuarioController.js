
var Maps = require('../models/mapsModel');
var Conn = require('../models/connection');
var Usuario = require('../models/usuarioModel');

 exports.selectAll = (req,res,next)=>{
     var usuario = new Usuario();
     usuario.selectAll(res);
 }


 
 exports.login = (req, res, next) => {
    var usuario = new Usuario();
    const email = req.body.email;
    const senha = req.body.senha;
    usuario.login(email,senha,res);
}
/*
exports.selectAll = (req,res,next) => {
    const usuario = new Usuario();
    usuario.selectAll(res);
    console.log(res.recordset);
}*/

/*
exports.getUser = (req, res, next) => {
    //var maps = new Maps("Wesley","123");
    //res.status(201).send(maps.save());
    //var conn = new Conn();
    //conn.connection('select * from usuarios',res);
    var usuario = new Usuario();
    usuario.selectAll(res);
};

exports.getUserById = (req,res,next) => {
    var usuario = new Usuario();
    var id = 0;
    if(req.params.id) id = parseInt(req.params.id);
    usuario.selectById(id,res);
}

//values undefineds preciso arrumar
exports.insertUser = (req,res,next) =>{
    var usuario = new Usuario();
    const email = req.body.email;
    const senha = req.body.senha;
    usuario.insertUser(email,senha,res);
}

exports.updateUser = (req, res, next) => {
    var usuario = new Usuario();
    var id = parseInt(req.params.id);
    var email = req.body.email;
    var senha = req.body.senha;
    usuario.updateUser(id,email,senha,res);
}

exports.deleteUser = (req, res, next) => {
    var usuario = new Usuario();
    var id = 0;
    if(req.params.id) id = parseInt(req.params.id);
    usuario.deleteUser(id,res);
}

exports.login = (req, res, next) => {
    var usuario = new Usuario();
    const email = req.body.email;
    const senha = req.body.senha;
    usuario.login(email,senha,res);
}*/
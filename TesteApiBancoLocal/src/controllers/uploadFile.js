var UploadFile = require('../models/uploadFileModel');


exports.uploadFile = (req, res, next) => {
    //Query banco de dados vem aqui
    var uploadFile = new UploadFile();
    var path = req.file.destination;
    var file = req.file.filename;
    var fullPath = path +"/"+ file;

    uploadFile.insertDocument(1, fullPath, res);
    console.log("file>>>", req.file);
    console.log("originalname>>>", req.file.originalname);
    console.log("path>>>", req.file.originalname);
    console.log("filename>>>", req.file.filename);
    console.log("destination>>>", req.file.destination)
    res.redirect('/');
};
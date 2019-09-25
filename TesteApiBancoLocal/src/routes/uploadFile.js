const express = require("express");
const router = express.Router();
var multer  = require('multer');

var storage = multer.diskStorage({
    destination: function (req, file, cb) {
      cb(null, 'src/uploads')//aqui define o diretório em q o arquivo será armazenado
    },
    filename: function (req, file, cb) {
      cb(null, file.fieldname + '-' + Date.now())// define o nome do arquivo
    }
});

var upload = multer({ storage: storage })

const controller = require("../controllers/uploadFile");//definir controller

router.post('/',upload.single('avatar'),controller.uploadFile);

module.exports = router;

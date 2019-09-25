const express = require("express")
const router = express.Router();
var Conn = require('../models/connection');
const controller = require('../controllers/usuarioController');//definir o controller usuario

router.get('/',(req, res) => res.json({ message: 'Functionando'}));
router.get('/usuarios', controller.getUser);
router.get('/usuarios/:id',controller.getUserById);
router.post('/usuarios',controller.insertUser);
router.post('/usuarios/login',controller.login);
router.patch('/usuarios/:id',controller.updateUser);
router.delete('/usuarios/:id',controller.deleteUser);

module.exports = router;
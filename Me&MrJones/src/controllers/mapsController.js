var Maps = require('../models/mapsModel');

exports.getUser = (req, res, next) => {
    var maps = new Maps("Wesley","123");
    res.status(201).send(maps.save());
    
};
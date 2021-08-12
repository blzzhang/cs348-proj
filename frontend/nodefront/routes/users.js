var express = require('express');
var router = express.Router();

const axios = require('axios');




/* GET users listing. */
router.get('/', function(req, res, next) {
    res.render('users', {
        title: 'Test'
    });
});

module.exports = router;

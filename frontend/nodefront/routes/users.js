var express = require('express');
var router = express.Router();
var name = require('../name');

const axios = require('axios');



/* GET users listing. */
router.get('/', function(req, res, next) {
    res.render('users', {
        name: name.name.username
    });
});

router.post('/', function(req, res) {
    let email = req.body.username;
    let pwd = req.body.pwd;

    axios.post('http://localhost:8080/students/login', null, {
        params: {
            email: email,
            password : pwd
        }})
        .then(resp => {

            name.name.username = resp['data']['name'];
            res.render('users', {
                name: name.name.username
            });

        })
        .catch(error => {
            console.error(error)
            res.render('users', {
                name: name.name.username
            });
        });
});

module.exports = router;

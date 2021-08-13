var express = require('express');
var router = express.Router();
const axios = require('axios')


/* GET page. */
router.get('/', function(req, res, next) {
    res.render('register');
});


router.post('/', function(req, res) {
    console.log('post');
    let uname = req.body.uname;
    let pwd = req.body.pwd;
    let name = req.body.name;
    let major = req.body.major;
    let s_id = req.body.s_id;
    let year = req.body.year;

    axios.post('http://localhost:8080/students/register', {
        email: uname,
        password : pwd,
        name : name
    })
        .then(resp => {
            console.log(`statusCode: ${resp.status}`);
            console.log(resp);
            res.render('users', {
                name: ""
            });
        })
        .catch(error => {
            console.error(error)
            res.render('register');
        });

});

module.exports = router;

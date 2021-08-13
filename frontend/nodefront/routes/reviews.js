var express = require('express');
var router = express.Router();
var axios = require('axios');
var name = require('../name');


// post
router.post('/', function(req, res, next) {
    let easy = req.body.easy;
    let interesting = req.body.interesting;
    let liked = req.body.liked;
    let useful = req.body.useful;
    let well_structured = req.body.well_structured;
    let rating = req.body.rating;
    let description = req.body.description;
    let name = name.name.username;
    let courseId = req.body.courseId;

    axios.post(`http://localhost:8080/reviews/${}add`, {
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

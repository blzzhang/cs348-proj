var express = require('express');
var router = express.Router();
var axios = require('axios');
var name = require('../name');
var courses = require('./courses');
const querystring = require('querystring');


// post
router.post('/', function(req, res, next) {
    let easy = req.body.easy;
    let interesting = req.body.interesting;
    let liked = req.body.liked;
    let useful = req.body.useful;
    let well_structured = req.body.well_structured;
    let rating = req.body.rating;
    let description = req.body.description;
    let courseName = req.body.courseName;
    let student_id = '3b7f049f-6127-4335-b5e1-02b6185c3653';

    console.log(req.body.description);

    axios.post(`http://localhost:8080/reviews/${student_id}/add`, {
        easy: easy,
        interesing : interesting,
        liked : liked,
        useful : useful,
        wellStructured : well_structured,
        rating : rating,
        description : description,
        courseName : courseName,
    })
        .then(resp => {
            console.log(resp);

            res.redirect('/courses?course='+courseName);

        })
        .catch(error => {
            // console.error(error);
            res.redirect('/courses?course='+courseName);
        });

});

module.exports = router;

var express = require('express');
var router = express.Router();
var https = require('https');
https.get('http://localhost:8080/courses/listAll', (resp) => {
    let data = '';

    resp.on('data', (chunk) => {
        data += chunk;
    });

    resp.on('end', () => {
        console.log(JSON.parse(data).explanation);
    });

}).on("error", (err) => {
    console.log("Error: " + err.message);
});


/* GET courses listing. */
router.get('/', function(req, res, next) {
    res.render('courses', { title: 'Test' });
});

module.exports = router;

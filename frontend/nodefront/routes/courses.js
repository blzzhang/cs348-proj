var express = require('express');
var router = express.Router();
var http = require('http');


function api_get_course(subject, catalog) {

    return new Promise((resolve, reject) => {
        http.get('http://localhost:8080/courses/4417', (res) => {
            var { statusCode } = res;
            var contentType = res.headers['content-type'];

            let error;

            if (statusCode !== 200) {
                error = new Error('Request Failed.\n' +
                    `Status Code: ${statusCode}`);
            } else if (!/^application\/json/.test(contentType)) {
                error = new Error('Invalid content-type.\n' +
                    `Expected application/json but received ${contentType}`);
            }

            if (error) {
                console.error(error.message);
                // consume response data to free up memory
                res.resume();
            }

            res.setEncoding('utf8');
            let rawData = '';

            res.on('data', (chunk) => {
                rawData += chunk;
            });

            res.on('end', () => {
                try {
                    const parsedData = JSON.parse(rawData);
                    resolve(parsedData);
                } catch (e) {
                    reject(e.message);
                }
            });
        }).on('error', (e) => {
            reject(`Got error: ${e.message}`);
        });
    });
}


/* GET courses listing. */
router.get('/', function(req, res, next) {
    let course_code = req.query.course_id || "cs348";
    let patt1 = /[a-zA-Z]/g;
    let patt2 = /[0-9]/g;
    let subject = course_code.match(patt1);
    let catalog_num = course_code.match(patt2);
    let course_data= {};
    api_get_course(subject, catalog_num)
        .then(response => {
        data = response[0];
        let courseId = data['courseId'];
        let subjectCode = data['subjectCode'];
        let termCode = data['termCode'];
        let title = data['title'];
        let instructors = data['instructors'];
        let description = data['description'];
        res.render('courses', {
            courseId: courseId,
            subjectCode: subjectCode,
            termCode: termCode,
            title: title,
            instructors: instructors,
            description: description
        });
        })
        .catch(error => {
            console.log(error);
        });
});

module.exports = router;

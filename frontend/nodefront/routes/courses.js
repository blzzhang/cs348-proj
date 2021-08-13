var express = require('express');
var router = express.Router();
var http = require('http');
var name = require('../name');
var axios = require('axios');


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

function get_courses(req, res) {
    console.log('name');
    console.log(name.name.username);
    let course_code = req.query.course || "cs348";
    let patt1 = /[a-zA-Z]/g;
    let patt2 = /[0-9]/g;
    let subject = course_code.match(patt1).join("").toUpperCase();
    let catalog_num = course_code.match(patt2).join("");
    console.log(subject);
    console.log(catalog_num);
    api_get_course(subject, catalog_num)
        .then(response => {
            data = response[0];
            let courseId = data['courseId'];
            let subjectCode = data['subjectCode'];
            let termCode = data['termCode'];
            let title = data['title'];
            let instructors = data['instructors'];
            let description = data['description'];
            let catalogNumber = data['catalogNumber'];
            let reviews = [];

            // reviews for course
            axios.get(`http://localhost:8080/reviews/listAllForCourse?courseName=${subjectCode+catalogNumber}`)
                .then(resp => {
                    var review_data = resp['data']
                    reviews = review_data;
                    console.log(reviews);
                    res.render('courses', {
                        courseId: courseId,
                        subjectCode: subjectCode,
                        termCode: termCode,
                        catalogNumber: catalogNumber,
                        title: title,
                        instructors: instructors,
                        description: description,
                        reviews: reviews
                    });
                })
                .catch(error => {
                    console.error(error);
                    res.redirect('/courses?course='+courseName);
                });
        })
        .catch(error => {
            console.log(error);
        });
};

function get_reviews() {

}

/* GET courses listing. */
router.get('/', function(req, res) {
    get_courses(req, res);
});

module.exports = router;

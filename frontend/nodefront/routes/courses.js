var express = require('express');
var router = express.Router();
var http = require('http');
var name = require('../name');


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
res.render('courses', {
            courseId: "348",
            subjectCode: "CS",
            termCode: "termCode",
            title: "Introduction to Database Management",
            instructors: "Xi He",
            description: "The main objective of this course is to introduce students to fundamentals of database technology by studying databases from three viewpoints: those of the database user, the database designer, and the database administrator. It teaches the use of a database management system (DBMS) by treating it as a black box, focusing only on its functionality and its interfaces. Topics include introduction to database systems, relational database systems, database design methodology, SQL and interfaces, database application development, concept of transactions, ODBC, JDBC, database tuning, database administration, and current topics (distributed databases, data warehouses, data mining). [Note: Lab is not scheduled and students are expected to find time in open hours to complete their work. Offered: F,W,S]"
        });

/*
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
        });*/
});

module.exports = router;

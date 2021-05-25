var mysql = require('mysql');
require('dotenv').config();

var con = mysql.createConnection({
    host: "localhost",
    user: process.env.DB_USER,
    password: process.env.DB_PASS,
    database: "testDB"
});

con.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");

    sql_select = "SELECT * from student;"
    con.query(sql_select, function (err, result) {
        if (err) throw err;
        rows = JSON.parse(JSON.stringify((result[0])));
        console.log("First Student: " + result[0].name);
    });
});


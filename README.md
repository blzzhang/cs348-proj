# MySQL Setup

(Follow Step 1 from the ProjectNode-PHPMySQL document on Learn, also copied below)

Follow the instructions here to install mysql locally
https://dev.mysql.com/doc/refman/8.0/en/installing.html

Then run the below code to populate your test db.
```
$ mysql -u root -p
mysql> CREATE DATABASE testDB;
mysql> USE testDB;
mysql> source <path_to_files>/droptables.sql
mysql> source <path_to_files>/createtables.sql
mysql> source <path_to_files>/populatedb.sql
```

# Test-sample

To see a sample of database features our app has, run the below. 
The output should be identical to test-sample.out
```
mysql> source <path_to_files>/test-sample.sql
```

# Test-production

To see a sample of database features our app has with production dataset, run the below. 
The output should be identical to test-production.out
```
mysql> source <path_to_files>/test-production.sql
```

# Environment Variable
Create a file called .env with your mysql user and pass set as required.
```
DB_USER=my_user
DB_PASS=my_pass
```

# Spring Boot Backend
This backend framework temporarily provides a way to populate the database with small sample data.
The framework reaches out to the University of Waterloo's OpenAPI and obtains courses and populates
them onto the local instance of mysql database.

# Prereq
Refer back to the previous section and make sure to have mysql running with the testDB created.

After creating the tables, you will need to make a new user by invoking the following commands:
```
mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
mysql> grant all on testDB.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database
```

# Data Setup Guide
Following these steps, you should be able to populate your database with real courses in
University of Waterloo for Spring 2021 term. Make sure to follow these steps sequentially.

## Background
- Have [php](https://www.php.net/manual/en/install.php) installed
- mySql is running with testDB and correct user created
- dropped tables prior to running RestapiApplication

## Populating Course data
Course table's data is populated by reaching out to the following endpoint:
```shell script
curl -v -X POST localhost:8080/courses/populate
```
Upon successful data setup, the console will display the following: `populated`.

## Populating Instructor data
However, the column instructor is not yet populated using this endpoint since UWaterloo's OpenData API does not provide
any instructor data.
- First, verify that courses.txt and instructors.txt under `src/main/resources` are present with data.
- If not, you need to run the shell script `cs348-proj/scrapers/populate.sh` before continuing.

After the above steps, there is another endpoint which needs to be hit:
```shell script
curl -v -X POST localhost:8080/courses/instructors
```
This will successfully populate instructor data and should print this on console: `instructors added`.
# Supported Features
Currently, there are several features you can use by making a request to our endpoints. 

```shell script
curl 'localhost:8080/courses/populate' ;populates the sample db (RestapiService.java, RestapiServiceImpl.java)
curl -v -X POST localhost:8080/courses/instructors ;updates the db entries with the list of instructors (RestapiServiceImpl.java)
curl 'localhost:8080/courses/{id}' ;gets the course by id (RestapiService.java, RestapiServiceImpl.java)
curl 'localhost:8080/students/register' ;post request to register a student account (StudentService.java, StudentServiceImpl.java)  
curl 'localhost:8080/students/listAll' ;gets all registers users (StudentService.java, StudentServiceImpl.java)  
curl 'localhost:8080/reviews/{id}/add' ;post request to create a new review (ReviewService.java, ReviewServiceImpl.java)  
curl 'localhost:8080/reviews/listAllForCourse?courseName={course}' ;gets all reviews for a particular course (ReviewService.java, ReviewServiceImpl.java)  
```


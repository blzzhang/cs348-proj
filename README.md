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

# Running & Usage
Currently, there are two endpoints you can reach out to, one that populates the DB with real, sample
data and an endpoint that will return the course based on the id provided.

```shell script
curl 'localhost:8080/courses/populate' ;populates the sample db
curl 'localhost:8080/courses/{id}' ;gets the course by id
```


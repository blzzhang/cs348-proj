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
```

# Environment Variable
Create a file called .env with your mysql user and pass set as required.
```
DB_USER=my_user
DB_PASS=my_pass
```

# Running
Run 
```
node demo_db_connection.js
```

The output should look like below if correctly setup.

![image](https://user-images.githubusercontent.com/30349597/119447857-812f2e00-bcfe-11eb-9953-af79d1efa8c0.png)


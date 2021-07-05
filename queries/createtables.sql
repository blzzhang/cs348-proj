CREATE TABLE instructor(
    ID INT(6) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255)
);

CREATE TABLE course(
    course_id INT(6) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    subject VARCHAR(20),
    title VARCHAR(255),
    detailed_name VARCHAR(255),
    description VARCHAR(255),
    location VARCHAR(255),
    major_only TINYINT(1),
    instructor_id INT(6),
    FOREIGN KEY (instructor_id) REFERENCES instructor(ID)
);


CREATE TABLE student(
    ID INT(6) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    create_time TIMESTAMP,
    email VARCHAR(255),
    password VARCHAR(255),
    name VARCHAR(255),
    major VARCHAR(255),
    uw_student_id VARCHAR(30),
    year VARCHAR(30)
);

CREATE TABLE enrolled(
    CourseID INT(6),
    StudentID INT(6),
    PRIMARY KEY(CourseID, StudentID),
    FOREIGN KEY(CourseID) REFERENCES course(ID),
    FOREIGN KEY(StudentID) REFERENCES student(ID)
);

CREATE TABLE course_prereqs (
    course_id INT(6),
    prerequisite_course_id INT(6),
    PRIMARY KEY(CourseID, PrerequisiteID),
    FOREIGN KEY(CourseID) REFERENCES course(ID),
    FOREIGN KEY(PrerequisiteID) REFERENCES course(ID)
);


CREATE TABLE review(
    id INT(6) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    course_name varchar(255),
    Rating INT(6),
    Liked INT(6),
    Useful INT(6),
    Easy INT(6),
    Interesting INT(6),
    WellStructured INT(6),
    StudentID INT(6),
    InstructorID INT(6),
    CourseID INT(6),
    Description VARCHAR(200),
    create_time TIMESTAMP,
    FOREIGN KEY(InstructorID) REFERENCES instructor(ID),
    FOREIGN KEY(StudentID) REFERENCES student(ID),
    FOREIGN KEY(CourseID) REFERENCES course(ID)
);

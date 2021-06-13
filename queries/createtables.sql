CREATE TABLE instructor(
    ID INT(6) NOT NULL PRIMARY KEY,
    Name VARCHAR(30)
);

CREATE TABLE course(
    ID INT(6) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(30),
    DetailedName VARCHAR(30),
    Description VARCHAR(30),
    Location VARCHAR(30),
    MajorStudentOnly TINYINT(1),
    InstructorID INT(6),
    FOREIGN KEY (InstructorID) REFERENCES instructor(ID)
);


CREATE TABLE student(
    ID INT(6) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(30),
    Major VARCHAR(30),
    StudyYear VARCHAR(30)
);

CREATE TABLE enrolled(
    CourseID INT(6),
    StudentID INT(6),
    PRIMARY KEY(CourseID, StudentID),
    FOREIGN KEY(CourseID) REFERENCES course(ID),
    FOREIGN KEY(StudentID) REFERENCES student(ID)
);

CREATE TABLE prerequisite(
    CourseID INT(6),
    PrerequisiteID INT(6),
    PRIMARY KEY(CourseID, PrerequisiteID),
    FOREIGN KEY(CourseID) REFERENCES course(ID),
    FOREIGN KEY(PrerequisiteID) REFERENCES course(ID)
);


CREATE TABLE feedback(
    ID INT(6) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Rating INT(6),
    Liked INT(6),
    Useful INT(6),
    Easy INT(6),
    Interesting INT(6),
    WellStructured INT(6),
    StudentID INT(6),
    InstructorID INT(6),
    CourseID INT(6),
    Description VARCHAR(30),
    SubmittedTime TIMESTAMP,
    FOREIGN KEY(InstructorID) REFERENCES instructor(ID),
    FOREIGN KEY(StudentID) REFERENCES student(ID),
    FOREIGN KEY(CourseID) REFERENCES course(ID)
);

-- instructor
insert into instructor (Name)
values ('Tim Apple');

insert into instructor (Name)
values ('John Teacher');

-- course
insert into course (title, detailed_name, Description, Location, major_only, instructor_id)
values (
'CS348', 'Introduction to Database Management',
'The main objective of this course is to introduce students to fundamentals of database technology by studying databases from three viewpoints: those of the database user, the database designer, and the database administrator.',
'MC 2042', 0, 1
);

insert into course (title, detailed_name, Description, Location, major_only, instructor_id)
values (
'CS350', 'Operating Systems',
'An introduction to the fundamentals of operating system function, design, and implementation. Topics include concurrency, synchronization, processes, threads, scheduling, memory management, file systems, device management, and security.',
'MC 4002', 1, 1
);

-- student
insert into student (Name, Major, year)
values ('Tim Student', 'CS', '3B');

-- feedback
insert into review (
Rating, Liked, Useful, Easy, Interesting, WellStructured, StudentID, InstructorID, CourseID, Description
)
values (2, 5, 5, 1, 4, 4, 1, 1, 1, 'CS 348 is really hard!');
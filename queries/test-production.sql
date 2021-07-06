-- 1
--select * from course limit 5;
-- omitted due to size
-- 2
insert into student (name, major, year, email, password, status, uw_student_id)
values ('Brendan Zhang', 'CFM', '4A', 'blzhang@uwaterloo.ca', 'badpassword', 1, '20720995');

-- 3
select * from student;

-- 4
insert into review  (Rating, Liked, Useful, Easy, Interesting, WellStructured, StudentID, InstructorID, CourseID, Description)
values (4, 5, 5, 3, 4, 4, 1, 1, 1, 'CS 348 is a great course!');

-- 5
select * from review
where courseID = 1;

-- 6
select c.Name, avg(f.Rating) as OverallRating
from course c
inner join
feedback f
on c.id = f.CourseID
where c.id = 1;

-- 7
select i.name
from course c
inner join
instructor i
on c.InstructorID = i.ID
where c.id = 1;

-- 8
select title
from course
where course_id in
(select prereqs_course_id
from course_prereqs
where course_id = 1);

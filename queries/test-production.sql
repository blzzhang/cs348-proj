-- 1
select title, description, detailed_name, location, major_only from course where course_id = 1;

-- 2
insert into student (name, major, year, email, password, status, uw_student_id)
values ('Brendan Zhang', 'CFM', '4A', 'blzhang@uwaterloo.ca', 'badpassword', 1, '20720995');

-- 3
insert into review  (Rating, Liked, Useful, Easy, Interesting, WellStructured, StudentID, InstructorID, CourseID, Description)
values (4, 5, 5, 3, 4, 4, 1, 1, 1, 'CS 348 is a great course!');

-- 4
select c.Name, avg(f.Rating) as OverallRating
from course c
inner join
feedback f
on c.id = f.CourseID
where c.id = 1;

-- 5
select i.name
from course c
inner join
instructor i
on c.InstructorID = i.ID
where c.id = 1;

-- 6

-- 1
select Name, DetailedName, Description, Location, MajorStudentOnly from course where id = 1;

-- 2
insert into student (Name, Major, StudyYear)
values ('Brendan Zhang', 'CFM', '4A');

-- 3
insert into feedback (Rating, Liked, Useful, Easy, Interesting, WellStructured, StudentID, InstructorID, CourseID, Description)
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
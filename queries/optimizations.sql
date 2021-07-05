-- 1

CREATE INDEX ind_reviews_by_course
ON reviews(course_name);


-- 2

CREATE INDEX ind_course_by_subject
ON course(subject);


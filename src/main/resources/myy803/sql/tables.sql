use myy803;

DROP TABLE IF EXISTS attends;
DROP TABLE IF EXISTS teaches;
DROP TABLE IF EXISTS instructors;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS courses;

set global local_infile=true;

CREATE TABLE instructors (
    firstname VARCHAR(50),
    lastname VARCHAR(50),
	username VARCHAR(50),
    password VARCHAR(50),
    enabled TINYINT,
    authority VARCHAR(50),
    PRIMARY KEY(username)
);

CREATE TABLE students (
	id INT AUTO_INCREMENT,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    year_of_registration DATETIME,
    PRIMARY KEY(id)
);

CREATE TABLE courses (
    course_name VARCHAR(50),
    semester INT,
    description TEXT,
    PRIMARY KEY(course_name)
);

CREATE TABLE teaches (
	instructor_username VARCHAR(50),
    course_name VARCHAR(50),
    FOREIGN KEY(course_name) REFERENCES courses(course_name) ON DELETE NO ACTION,
    FOREIGN KEY(instructor_username) REFERENCES instructors(username) ON DELETE NO ACTION,
    PRIMARY KEY(instructor_username, course_name)
);

CREATE TABLE attends (
    student_id INT,
    course_name VARCHAR(50),
    grade FLOAT,
    FOREIGN KEY(student_id) REFERENCES students(id) ON DELETE NO ACTION,
    FOREIGN KEY(course_name) REFERENCES courses(course_name) ON DELETE NO ACTION,
    PRIMARY KEY(student_id,course_name)
);

LOAD DATA LOCAL INFILE "C:\\Users\\#\\#\\#\\instructors.csv" INTO TABLE instructors FIELDS
TERMINATED BY "," ENCLOSED BY '\"' LINES TERMINATED BY "\n" (firstname,lastname,username,password,enabled,authority);

LOAD DATA LOCAL INFILE "C:\\Users\\#\\#\\#\\students.csv" INTO TABLE students FIELDS
TERMINATED BY "," ENCLOSED BY '\"' LINES TERMINATED BY "\n" (firstname,lastname,year_of_registration);

LOAD DATA LOCAL INFILE "C:\\Users\\#\\#\\#\\courses.csv" INTO TABLE courses FIELDS
TERMINATED BY "," ENCLOSED BY '\"' LINES TERMINATED BY "\n" (course_name,semester,description);

LOAD DATA LOCAL INFILE "C:\\Users\\#\\#\\#\\teaches.txt" INTO TABLE teaches FIELDS
TERMINATED BY "," ENCLOSED BY '\"' LINES TERMINATED BY "\n" (instructor_username,course_name);

LOAD DATA LOCAL INFILE "C:\\Users\\#\\#\\#\\attendswithgrade.csv" INTO TABLE attends FIELDS
TERMINATED BY "," ENCLOSED BY '\"' LINES TERMINATED BY "\n" (student_id,course_name,grade);


SELECT * FROM courses;
SELECT * FROM instructors;
SELECT * FROM teaches;
select * from students;
select * from attends;
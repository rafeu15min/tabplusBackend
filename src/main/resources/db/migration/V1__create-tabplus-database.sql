-- Active: 1713108079449@@mysql-tabplus-tabplus-database.b.aivencloud.com@17180@defaultdb
CREATE TABLE `teacher` (
    `teacher_id` integer UNIQUE PRIMARY KEY NOT NULL auto_increment,
    `teacher_name` varchar(255),
    `teacher_password` varchar(255),
    `teacher_email` VARCHAR(255)
);

CREATE TABLE `school_class` (
    `school_class_id` integer UNIQUE PRIMARY KEY NOT NULL auto_increment,
    `school_class_grade` varchar(255), 
    `school_class_year` integer
);

CREATE TABLE `student` (
    `student_id` integer UNIQUE PRIMARY KEY NOT NULL auto_increment,
    `student_name` varchar(255), 
    `student_alias` varchar(255), 
    `student_password` varchar(255), 
    `school_class_id` integer
);

CREATE TABLE `turn` (
    `turn_id` integer UNIQUE PRIMARY KEY NOT NULL auto_increment, 
    `student_id` integer, 
    `created_at` timestamp
);

CREATE TABLE `operation` (
    `operation_id` integer UNIQUE PRIMARY KEY NOT NULL auto_increment, 
    `first_term` integer, 
    `second_term` integer, 
    `result` integer, 
    `answer` integer, 
    `is_correct_answer` integer, 
    `turn_id` integer
);

CREATE TABLE `school_class_teacher` (
    `school_class_id` integer,
    `teacher_id` integer,
    PRIMARY KEY (`school_class_id`, `teacher_id`)
);

ALTER TABLE `school_class_teacher`
ADD FOREIGN KEY (`school_class_id`) REFERENCES `school_class` (`school_class_id`);

ALTER TABLE `school_class_teacher`
ADD FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`);

ALTER TABLE `student`
ADD FOREIGN KEY (`school_class_id`) REFERENCES `school_class` (`school_class_id`);

ALTER TABLE `turn`
ADD FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`);

ALTER TABLE `operation`
ADD FOREIGN KEY (`turn_id`) REFERENCES `turn` (`turn_id`);
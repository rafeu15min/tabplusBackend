-- Active: 1713108079449@@mysql-tabplus-tabplus-database.b.aivencloud.com@17180@defaultdb

CREATE TABLE `school_class` (
    `school_class_id` integer UNIQUE PRIMARY KEY NOT NULL auto_increment,
    `school_class_grade` varchar(255), 
    `school_class_year` integer
);
CREATE TABLE `student` (
    `student_id` integer UNIQUE PRIMARY KEY NOT NULL auto_increment,
    `student_name` varchar(255), 
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

ALTER TABLE `student`
ADD FOREIGN KEY (`school_class_id`) REFERENCES `school_class` (`school_class_id`);

ALTER TABLE `turn`
ADD FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`);

ALTER TABLE `operation`
ADD FOREIGN KEY (`turn_id`) REFERENCES `turn` (`turn_id`);
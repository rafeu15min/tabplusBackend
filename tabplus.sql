CREATE TABLE `teacher` (
  `teacher_id` integer UNIQUE PRIMARY KEY,
  `teacher_name` varchar(255),
  `password` varchar(255),
  `email` varchar(255)
);

CREATE TABLE `class` (
  `class_id` integer UNIQUE PRIMARY KEY,
  `class_grade` varchar(255),
  `class_year` integer
);

CREATE TABLE `student` (
  `student_id` integer UNIQUE PRIMARY KEY,
  `student_name` varchar(255),
  `student_alias` varchar(255),
  `class_id` integer
);

CREATE TABLE `turn` (
  `turn_id` integer UNIQUE PRIMARY KEY,
  `student_id` integer,
  `created_at` timestamp
);

CREATE TABLE `operation` (
  `operation_id` integer UNIQUE PRIMARY KEY,
  `first_term` integer,
  `second_term` integer,
  `result` integer,
  `answer` integer,
  `is_correct_answer` integer,
  `turn_id` integer
);

CREATE TABLE `class_teacher` (
  `class_class_id` integer,
  `teacher_teacher_id` integer,
  PRIMARY KEY (`class_class_id`, `teacher_teacher_id`)
);

ALTER TABLE `class_teacher` ADD FOREIGN KEY (`class_class_id`) REFERENCES `class` (`class_id`);

ALTER TABLE `class_teacher` ADD FOREIGN KEY (`teacher_teacher_id`) REFERENCES `teacher` (`teacher_id`);


ALTER TABLE `class` ADD FOREIGN KEY (`class_id`) REFERENCES `student` (`class_id`);

ALTER TABLE `student` ADD FOREIGN KEY (`student_id`) REFERENCES `turn` (`student_id`);

ALTER TABLE `turn` ADD FOREIGN KEY (`turn_id`) REFERENCES `operation` (`turn_id`);

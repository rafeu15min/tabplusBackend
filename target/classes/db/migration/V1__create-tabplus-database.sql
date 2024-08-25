-- Active: 1713108079449@@mysql-tabplus-tabplus-database.b.aivencloud.com@17180@defaultdb

CREATE TABLE `game` (
    `game_id` integer UNIQUE PRIMARY KEY NOT NULL auto_increment,
    `game_grade` varchar(2), 
    `game_year` integer,
    `player` varchar(255),
    `hits` integer, -- quantidade de acertos
    `multiplication` VARCHAR(10),
    `answer` integer, -- resposta fornecida pelo usuário
    `result` integer -- resposta certa
);
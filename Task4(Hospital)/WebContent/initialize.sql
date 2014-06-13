set names utf8;
drop database if exists hospital;
create database hospital;
use hospital;

create table patients (id int not null auto_increment, name text, surname text, pathronimic text, primary key(id)) default charset=utf8;
insert into patients (name, surname, pathronimic) values
('Иван', 'Иванов', 'Иванович'),
('Степан', 'Степанов', 'Степанович'),
('Сидор', 'Сидоров', 'Сидорович'),
('Василий', 'Васильев', 'Васильевич'),
('Иоан', 'Рюрикович', 'Иоанович'),
('Владимир', 'Путин', 'Владимирович'),
('Homer', 'Simpson', 'J'),
('Jonh', 'Shepard', ''),
('Anakin', 'Skywalker', 'Any');

create table diagnosis (id int not null auto_increment, diaName text, primary key(id)) default charset=utf8;
insert into diagnosis (diaName) values
('Завышеное ЧСВ'),
('Паталогическая лень'),
('Маразм'),
('Жажда силы'),
('Cold'),
('Canser'),
('Acute appendicitis'),
('Ileus'),
('Gastric ulcer');

create table drugs (id int not null auto_increment, drugName text, primary key(id)) default charset=utf8;
insert into drugs (drugName) values
('Пурген'),
('Активированный уголь'),
('Терафлю'),
('Валерьянка'),
('Omez D'),
('Morphine');

create table procedures (id int not null auto_increment, procName text, primary key(id)) default charset=utf8;
insert into procedures (procName) values
('Капельница глюкозы'),
('Клизма'),
('Клизма побольше'),
('Перевязка'),
('Esophagogastroduodenoscopy'),
('Chemotherapy');

create table operations (id int not null auto_increment, operName text, primary key(id)) default charset=utf8;
insert into operations (operName) values
('Вырезать гланды'),
('Вырезать апендицит'),
('Собрать кость'),
('Наложить гипс'),
('Вырезать опухоль');

create table patientDiagnosis (patientID int, diagnosisID int, primary key(patientID, diagnosisID)) default charset=utf8;
insert into patientDiagnosis (patientID, diagnosisID) values
(1, 5),
(2, 6),
(3, 7),
(4, 9),
(5, 1),
(6, 3),
(7, 2),
(8, 8),
(9, 4);

create table patientDrugs (patientID int, drugsID int, primary key(patientID, drugsID)) default charset=utf8;
insert into patientDrugs (patientID, drugsID) values
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(8, 2),
(9, 2);

create table patientProcedures (patientID int, ProceduresID int, primary key(patientID, ProceduresID)) default charset=utf8;
insert into patientProcedures (patientID, ProceduresID) values
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 3),
(7, 2),
(8, 2),
(9, 2);

create table patientOperations (patientID int, OperationsID int, primary key(patientID, OperationsID)) default charset=utf8;
insert into patientOperations (patientID, OperationsID) values
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 4),
(7, 1),
(8, 1),
(9, 1);


create table discharged(patientID int, name text, surname text, pathronimic text, diagnosisName text, primary key(patientID)) default charset=utf8;

create table users (id int not null auto_increment, login text, role int, primary key(id, role)) default charset=utf8;
insert into users (login, role) values
('Qwerty', 1),
('Freeze', 2),
('Fridon', 3);

create table passwords (userID int unique, password text, primary key(userID)) default charset=utf8;
insert into passwords (userID, password) values
(1, '1234567890'),
(2, 'qwertyuiop'),
(3, 'asdfghjkl');




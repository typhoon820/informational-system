/*Заполнение таблицы CYCLE */
insert into cycle (name)
values('Математический');
insert into cycle (name)
values('Гумманитарный');
insert into cycle (name)
values('Филологический');
insert into cycle (name)
values('Общеинженерный');
insert into cycle (name)
values('Компьютерный');
insert into cycle (name)
values('Медицинский');
/* Заполнение таблицы SUBJECT */
set foreign_key_checks = 0;
alter table subject
modify ID INT auto_increment;
set foreign_key_checks = 1;

insert into subject (name, cycleID)
values('Алгебра',1);
insert into subject (name, cycleID)
values('Геометрия',1);
insert into subject (name, cycleID)
values('Функциональный анализ',1);
insert into subject (name, cycleID)
values('Дискретная математика',1);
insert into subject (name, cycleID)
values('Литература 20 века',2);
insert into subject (name, cycleID)
values('История',2);
insert into subject (name, cycleID)
values('Социология',2);
insert into subject (name, cycleID)
values('Философия',2);
insert into subject (name, cycleID)
values('Античная литература',2);
insert into subject (name, cycleID)
values('Риторика',3);
insert into subject (name, cycleID)
values('Английский язык',3);
insert into subject (name, cycleID)
values('Русский язык',3);
insert into subject (name, cycleID)
values('Немецкий язык',3);
insert into subject (name, cycleID)
values('Анлийская литература  ',3);

insert into subject (name, cycleID)
values('Теоретическая механика',4);
insert into subject (name, cycleID)
values('Физика',4);
insert into subject (name, cycleID)
values('Сопромат',4);
insert into subject (name, cycleID)
values('Гидравлика',4);

insert into subject (name, cycleID)
values('Информатика',5);
insert into subject (name, cycleID)
values('ОЗИ',5);
insert into subject (name, cycleID)
values('Базы данных',5);
insert into subject (name, cycleID)
values('ООП',5);



insert into subject (name, cycleID)
values('Биология',6);
insert into subject (name, cycleID)
values('Анатомия',6);
insert into subject (name, cycleID)
values('Химия',6);
insert into subject (name, cycleID)
values('Паразитология',6);



set foreign_key_checks = 0;
alter table schedule
modify ID INT auto_increment;
set foreign_key_checks = 1;


insert into position (position)
values('Преподаватель');
insert into position (position)
values('Заведующий кафедрой');


/*Insertion to TEACHER */

insert into teacher (FIO, adress,scientific_degree,positionID, phone)
values('Петров Федор Павлович','университетская пл., д.1','профессор',2, '8005553535');
insert into teacher (FIO, adress,scientific_degree,positionID, phone)
values('Федоров Алексей Павлович','ул.Станкевича, д.23','доцент',1, '0009087867');
insert into teacher (FIO, adress,scientific_degree,positionID, phone)
values('Андреев Виктор Степанович','ул. Лизюкова, д.53','профессор',2, '3456782211');
insert into teacher (FIO, adress,scientific_degree,positionID, phone)
values('Петров Петр Романович','ул.Декабристов, д.33','профессор',2, '2345668998');
insert into teacher (FIO, adress,scientific_degree,positionID, phone)
values('Антонов Игорь Николаевич','университетская пл., д.4','профессор',1, '2887665454');
insert into teacher (FIO, adress,scientific_degree,positionID, phone)
values('Свиридов Тихон Никитович','ул. Шишкова, д. 46','доцент',1, '2988907766');
insert into teacher (FIO, adress,scientific_degree,positionID, phone)
values('Саввельев Анатолий Григорьевич','пер. Дальний, д.14','доцент',1, '9655621331');

/*Insertion into SUBJECT_TEACHER */






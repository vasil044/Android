create table notas(
_id int(4),
categoria text NOT NULL,
titulo text NOT NULL,
descripcion text NOT NULL,
CONSTRAINT pk_id PRIMARY KEY(_id));

insert into notas()
values(1,'Festival/Concierto','Download, Guns n Roses','Festival Download Madrid, concierto de Guns n Roses');
values(2,'Festival/Concierto','Resurrection, Enter Shikari','Resurrection Festival Galicia, concierto de Enter Shikari.');
values(3,'Juegos de mesa','Torneo Magic','Torneo Standard de Magic. 5:00. Alquimia.');
values(4,'Cena','Quedada antiguos alumnos.','Quedada con antiguos alumnos de bachillerato.');
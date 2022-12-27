DROP TABLE IF EXISTS moons, planets, users;

-- Use this script to setup your Planetarium database
CREATE TABLE users(
	-- serial starts at 1 and auto generates
	id serial primary key,
	username varchar(20) unique,
	password varchar(20)
);

CREATE TABLE planets(
	id serial primary key,
	name varchar(20),
	ownerId int references users(id) on delete cascade
);

CREATE TABLE moons(
	id serial primary key,
	name varchar(20),
	myPlanetId int references planets(id) on delete cascade
);

INSERT INTO	users VALUES (default, 'test', 'test');

INSERT INTO planets
VALUES (DEFAULT, 'Mercury', 1),
       (DEFAULT, 'Venus', 1),
       (DEFAULT, 'Earth', 1),
       (DEFAULT, 'Mars', 1),
       (DEFAULT, 'Jupiter', 1),
       (DEFAULT, 'Saturn', 1),
       (DEFAULT, 'Uranus', 1),
       (DEFAULT, 'Neptune', 1),
       (DEFAULT, 'Pluto', 1),
       (DEFAULT, 'Eris', 1),
       (DEFAULT, 'Makemake', 1),
       (DEFAULT, 'Haumea', 1),
       (DEFAULT, 'Ceres', 1);

INSERT INTO moons
VALUES (DEFAULT, 'Moon', 3),
       (DEFAULT, 'Io', 5),
       (DEFAULT, 'Europa', 5),
       (DEFAULT, 'Ganymede', 5),
       (DEFAULT, 'Callisto', 5),
       (DEFAULT, 'Titan', 6),
       (DEFAULT, 'Tethys', 6),
       (DEFAULT, 'Dione', 6),
       (DEFAULT, 'Rhea', 6),
       (DEFAULT, 'Enceladus', 6);
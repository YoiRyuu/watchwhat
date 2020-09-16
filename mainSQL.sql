-- create new database
DROP DATABASE IF EXISTS wwdb;
CREATE DATABASE IF NOT EXISTS wwdb;
USE wwdb;

-- create tables
CREATE TABLE aboutme(
	verid			INT AUTO_INCREMENT,
	ver				VARCHAR(10),
    notepatch		VARCHAR(500),
    PRIMARY KEY (verid)
);

CREATE TABLE accounts(
	acc_id				INT AUTO_INCREMENT,
    acc_username		VARCHAR(32)	NOT NULL UNIQUE,
    acc_password		VARCHAR(32) NOT NULL,
    acc_status			TINYINT	DEFAULT 1,
    acc_create_since	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    acc_birthdate		DATE NOT NULL,
    acc_email			VARCHAR(100) NOT NULL UNIQUE,
    acc_fullname		VARCHAR(100),
    PRIMARY KEY (acc_id)
);
CREATE TABLE movies(
	movie_id 			INT AUTO_INCREMENT,
	movie_name 			VARCHAR(100) NOT NULL,
	movie_directors 	VARCHAR(100) DEFAULT "unknown",
    movie_casts			VARCHAR(500) DEFAULT "unknown",
	movie_year 			SMALLINT NOT NULL,
	movie_premiereDay 	DATE,
	movie_coverImage 	VARCHAR(500) DEFAULT "noCover.jpg",
	movie_Certificate 	VARCHAR(10) DEFAULT "8+",
    movie_Rate 			DOUBLE DEFAULT 0,
    movie_Description 	VARCHAR(1000) DEFAULT "noDescription",
	PRIMARY KEY (movie_id)
);

CREATE TABLE favourites(
	fav_id				INT AUTO_INCREMENT,
    acc_id				INT,
    movie_id			INT,
    fav_status			TINYINT	DEFAULT 1,
    PRIMARY KEY	(fav_id),
    FOREIGN KEY(acc_id) REFERENCES accounts(acc_id),
    FOREIGN KEY(movie_id) REFERENCES movies(movie_id)
);

CREATE TABLE nations(
	nation_id			INT AUTO_INCREMENT,
    nation_name			VARCHAR(50) NOT NULL,
    PRIMARY KEY(nation_id)
);
CREATE TABLE nationsClassification(
	nc_id				INT AUTO_INCREMENT,
    nation_id			INT,
    movie_id			INT,
    PRIMARY KEY(nc_id),
    FOREIGN KEY(nation_id) REFERENCES nations(nation_id),
    FOREIGN KEY(movie_id) REFERENCES movies(movie_id)
);

CREATE TABLE tags(
	tag_id				INT AUTO_INCREMENT,
    tag_name			VARCHAR(50) NOT NULL,
    PRIMARY KEY(tag_id)
);
CREATE TABLE tagsClassification(
	tc_id				INT AUTO_INCREMENT,
    tag_id				INT,
    movie_id			INT,
    PRIMARY KEY(tc_id),
    FOREIGN KEY(tag_id) REFERENCES tags(tag_id),
    FOREIGN KEY(movie_id) REFERENCES movies(movie_id)
);

CREATE TABLE sources(
	source_id			INT AUTO_INCREMENT,
    movie_id			INT,
    source_episode 		INT DEFAULT 0,
    source_url_watch 	VARCHAR(500),
    source_url_download VARCHAR(500),
    PRIMARY KEY(source_id),
    FOREIGN KEY(movie_id) REFERENCES movies(movie_id)
);

-- Create Procedures

delimiter //
CREATE PROCEDURE insert_acc(IN acc_user VARCHAR(32), acc_pass VARCHAR(32), acc_bd DATE, acc_email VARCHAR(100), acc_name VARCHAR(100))
BEGIN
	INSERT INTO accounts (acc_username, acc_password, acc_status, acc_birthdate, acc_email, acc_fullname)
    VALUES (acc_user, acc_pass, 1, acc_bd, acc_email, acc_name);
END //
delimiter ;
-- CALL insert_acc('admin3','mamama','2000-1-1','cloudinsun@gmail.com','FINAL BOSS');

delimiter //
CREATE PROCEDURE update_acc(IN user_id INT, acc_bd DATE, acc_mail VARCHAR(100), acc_name VARCHAR(100))
BEGIN
	UPDATE accounts
	SET acc_birthdate = acc_bd, acc_email = acc_mail, acc_fullname = acc_name
	WHERE acc_id = user_id;
END //
delimiter ;

delimiter //
CREATE PROCEDURE change_pass(IN user_id INT, acc_pass VARCHAR(32))
BEGIN
	UPDATE accounts
	SET acc_password = acc_pass
	WHERE acc_id = user_id;
END //
delimiter ;

delimiter //
CREATE PROCEDURE getallmovies()
BEGIN
	SELECT a.movie_id, a.movie_name, a.movie_directors, a.movie_casts, a.movie_year, a.movie_premiereDay, a.movie_coverImage, a.movie_Certificate, a.movie_Rate, a.movie_Description, c.nation_name, e.tag_name
    FROM movies AS a
		INNER JOIN nationsclassification AS b ON a.movie_id = b.movie_id
		INNER JOIN nations AS c ON b.nation_id = c.nation_id
		INNER JOIN tagsclassification AS d ON a.movie_id = d.movie_id
		INNER JOIN tags AS e ON d.tag_id = e.tag_id;
END //
delimiter ;

delimiter //
CREATE PROCEDURE search_movie_name(IN input VARCHAR(100))
BEGIN
	SELECT a.movie_id, a.movie_name, a.movie_directors, a.movie_casts, a.movie_year, a.movie_premiereDay, a.movie_coverImage, a.movie_Certificate, a.movie_Rate, a.movie_Description, c.nation_name, e.tag_name
    FROM movies AS a
		INNER JOIN nationsclassification AS b ON a.movie_id = b.movie_id
		INNER JOIN nations AS c ON b.nation_id = c.nation_id
		INNER JOIN tagsclassification AS d ON a.movie_id = d.movie_id
		INNER JOIN tags AS e ON d.tag_id = e.tag_id
    WHERE a.movie_name LIKE concat('%',input,'%');
END //
delimiter ;
CALL search_movie_name('a')

delimiter //
CREATE PROCEDURE search_nation(IN input INT)
BEGIN
	SELECT a.movie_id, a.movie_name, a.movie_directors, a.movie_casts, a.movie_year, a.movie_premiereDay, a.movie_coverImage, a.movie_Certificate, a.movie_Rate, a.movie_Description, c.nation_name, e.tag_name
    FROM movies AS a
		INNER JOIN nationsclassification AS b ON a.movie_id = b.movie_id
		INNER JOIN nations AS c ON b.nation_id = c.nation_id
		INNER JOIN tagsclassification AS d ON a.movie_id = d.movie_id
		INNER JOIN tags AS e ON d.tag_id = e.tag_id
    WHERE c.nation_id = input;
END //
delimiter ;

delimiter //
CREATE PROCEDURE search_tag(IN input INT)
BEGIN
	SELECT a.movie_id, a.movie_name, a.movie_directors, a.movie_casts, a.movie_year, a.movie_premiereDay, a.movie_coverImage, a.movie_Certificate, a.movie_Rate, a.movie_Description, c.nation_name, e.tag_name
    FROM movies AS a
		INNER JOIN nationsclassification AS b ON a.movie_id = b.movie_id
		INNER JOIN nations AS c ON b.nation_id = c.nation_id
		INNER JOIN tagsclassification AS d ON a.movie_id = d.movie_id
		INNER JOIN tags AS e ON d.tag_id = e.tag_id
    WHERE e.tag_id = input;
END //
delimiter ;

delimiter //
CREATE PROCEDURE search_movie_director(IN input VARCHAR(100))
BEGIN
	SELECT a.movie_id, a.movie_name, a.movie_directors, a.movie_casts, a.movie_year, a.movie_premiereDay, a.movie_coverImage, a.movie_Certificate, a.movie_Rate, a.movie_Description, c.nation_name, e.tag_name
    FROM movies AS a
		INNER JOIN nationsclassification AS b ON a.movie_id = b.movie_id
		INNER JOIN nations AS c ON b.nation_id = c.nation_id
		INNER JOIN tagsclassification AS d ON a.movie_id = d.movie_id
		INNER JOIN tags AS e ON d.tag_id = e.tag_id
    WHERE a.movie_directors LIKE concat('%',input,'%');
END //
delimiter ;

delimiter //
CREATE PROCEDURE search_movie_casts(IN input VARCHAR(100))
BEGIN
	SELECT a.movie_id, a.movie_name, a.movie_directors, a.movie_casts, a.movie_year, a.movie_premiereDay, a.movie_coverImage, a.movie_Certificate, a.movie_Rate, a.movie_Description, c.nation_name, e.tag_name
    FROM movies AS a
		INNER JOIN nationsclassification AS b ON a.movie_id = b.movie_id
		INNER JOIN nations AS c ON b.nation_id = c.nation_id
		INNER JOIN tagsclassification AS d ON a.movie_id = d.movie_id
		INNER JOIN tags AS e ON d.tag_id = e.tag_id
    WHERE a.movie_casts LIKE concat('%',input,'%');
END //
delimiter ;

delimiter //
CREATE PROCEDURE add_movie_infor(IN mov_name VARCHAR(100), mov_dire VARCHAR(100), mov_cast VARCHAR(500), mov_year SMALLINT, mov_pred DATE, mov_cove VARCHAR(500), mov_cert VARCHAR(10), mov_Rate DOUBLE, mov_desc VARCHAR(1000))
BEGIN
	INSERT INTO movies (movie_name, movie_directors, movie_casts, movie_year, movie_premiereDay, movie_coverImage, movie_Certificate, movie_Rate, movie_Description)
	VALUES (mov_name, mov_dire, mov_cast, mov_year, mov_pred, mov_cove, mov_cert, mov_Rate, mov_desc);
END //
delimiter ;

delimiter //
CREATE PROCEDURE add_movie_nations(IN nat_id INT, mov_id INT)
BEGIN
	INSERT INTO nationsclassification (nation_id,movie_id)
	VALUES (nat_id, mov_id);
END //
delimiter ;

delimiter //
CREATE PROCEDURE add_movie_tags(IN tagid INT, mov_id INT)
BEGIN
	INSERT INTO tagsclassification (tag_id,movie_id)
	VALUES (tagid, mov_id);
END //
delimiter ;

delimiter //
CREATE PROCEDURE update_movie_infor(IN mov_id INT,mov_name VARCHAR(100), mov_dire VARCHAR(100), mov_cast VARCHAR(500), mov_year SMALLINT, mov_pred DATE, mov_cove VARCHAR(500), mov_cert VARCHAR(10), mov_desc VARCHAR(1000))
BEGIN
	UPDATE movies
	SET movie_name = mov_name, movie_directors = mov_dire, movie_casts = mov_cast, movie_year = mov_year, movie_premiereDay = mov_pred, movie_coverImage = mov_cove, movie_Certificate = mov_cert, movie_Description = mov_desc
	WHERE movie_id = mov_id;
END //
delimiter ;
-- DROP PROCEDURE update_movie_infor

delimiter //
CREATE PROCEDURE add_movie_episode(IN sc_id INT, mov_id INT, sc_ep INT, sc_wat VARCHAR(500), sc_down VARCHAR(500))
BEGIN
	INSERT INTO sources (movie_id, source_episode, source_url_watch, source_url_download)
	VALUES (mov_id, sc_ep, sc_wat, sc_down);
END //
delimiter ;

delimiter //
CREATE PROCEDURE update_movie_episode(IN sc_id INT, sc_wat VARCHAR(500), sc_down VARCHAR(500))
BEGIN
	UPDATE sources
	SET source_url_watch = sc_wat, source_url_download = sc_down
	WHERE source_id = sc_id;
END //
delimiter ;

delimiter //
CREATE PROCEDURE add_favourite(IN input int, input2 int)
BEGIN
	INSERT INTO favourites (acc_id, movie_id)
	VALUES (input, input2);
END //
delimiter ;

delimiter //
CREATE PROCEDURE update_favourite(IN input int, input2 int)
BEGIN
	UPDATE favourites
	SET fav_status = 1
	WHERE acc_id = input AND movie_id = input2;
END //
delimiter ;

delimiter //
CREATE PROCEDURE remove_favourite(IN input int, input2 int)
BEGIN
	UPDATE favourites
	SET fav_status = 0
    WHERE acc_id = input AND movie_id = input2;
END //
delimiter ;

delimiter //
CREATE PROCEDURE view_favourite(IN cus_id int)
BEGIN
	SELECT a.movie_id, a.movie_name, a.movie_directors, a.movie_casts, a.movie_year, a.movie_premiereDay, a.movie_coverImage, a.movie_Certificate, a.movie_Rate, a.movie_Description, c.nation_name, e.tag_name
    FROM movies AS a
		INNER JOIN nationsclassification AS b ON a.movie_id = b.movie_id
		INNER JOIN nations AS c ON b.nation_id = c.nation_id
		INNER JOIN tagsclassification AS d ON a.movie_id = d.movie_id
		INNER JOIN tags AS e ON d.tag_id = e.tag_id
        INNER JOIN favourites AS f ON a.movie_id = f.movie_id
        INNER JOIN accounts AS g ON f.acc_id = g.acc_id
    WHERE g.acc_id = cus_id AND f.fav_status = 1
    ORDER BY f.fav_id DESC;
END //
delimiter ;

delimiter //
CREATE PROCEDURE getmovieId(IN input VARCHAR(100))
BEGIN
	SELECT a.movie_id, a.movie_name, a.movie_directors, a.movie_casts, a.movie_year, a.movie_premiereDay, a.movie_coverImage, a.movie_Certificate, a.movie_Rate, a.movie_Description, c.nation_name, e.tag_name
    FROM movies AS a
		INNER JOIN nationsclassification AS b ON a.movie_id = b.movie_id
		INNER JOIN nations AS c ON b.nation_id = c.nation_id
		INNER JOIN tagsclassification AS d ON a.movie_id = d.movie_id
		INNER JOIN tags AS e ON d.tag_id = e.tag_id
    WHERE a.movie_id = input;
END //
delimiter ;
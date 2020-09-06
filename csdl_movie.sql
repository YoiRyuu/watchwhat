-- create new database
DROP DATABASE IF EXISTS csdl_movie;
CREATE DATABASE IF NOT EXISTS csdl_movie;
USE csdl_movie;

-- create tables
CREATE TABLE movies(
	movie_id 			INT AUTO_INCREMENT,
	movie_name 			NVARCHAR(90) NOT NULL,
	movie_directors 	NVARCHAR(50),
	movie_year 			INT,
	movie_premiereDay 	DATE,
	movie_cast 			NVARCHAR(50) ,
	movie_coverImage 	VARCHAR(500) ,
	movie_Certificate 	VARCHAR(20) ,
    movie_Rate 			DOUBLE,
    movie_Description 	NVARCHAR(1000),
	PRIMARY KEY (movie_id)
);
CREATE TABLE sources(
	sc_id				INT AUTO_INCREMENT,
    sc_episode			INT,
    sc_url				VARCHAR(550) NOT NULL,
    movie_id			INT,
	PRIMARY KEY (sc_id),
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);
CREATE TABLE tag(
	tag_id			INT AUTO_INCREMENT,
    tag_name		NVARCHAR(50) NOT NULL,
    PRIMARY KEY (tag_id)
);
CREATE TABLE tagClassification(
	id				INT PRIMARY KEY,
	tag_id 			INT,
    movie_id		INT,
	FOREIGN KEY (tag_id) REFERENCES tag(tag_id),
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);
CREATE TABLE nations(
	nation_id		INT AUTO_INCREMENT,
    nation_name		NVARCHAR(50) NOT NULL,
    PRIMARY KEY (nation_id)
);
CREATE TABLE nationsClassification(
	id					INT PRIMARY KEY,
	nation_id 			INT,
    movie_id			INT,
	FOREIGN KEY (nation_id) REFERENCES nations(nation_id),
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);
CREATE TABLE customers(
	ctm_id				INT AUTO_INCREMENT,
    ctm_name			NVARCHAR(30) NOT NULL,
    ctm_email			NVARCHAR(50) NOT NULL UNIQUE,
    ctm_brithday		DATE,
    ctm_since			DATE,
    ctm_status			TINYINT DEFAULT 1,
    ctm_lever			TINYINT DEFAULT 1,
    ctm_account			VARCHAR(30) NOT NULL UNIQUE,
    ctm_pass			NVARCHAR(32) NOT NULL,
	PRIMARY KEY (ctm_id)
);
CREATE TABLE Favourites(
	fav_id			INT AUTO_INCREMENT,
    ctm_id			INT,
    movie_id		INT,
    stt				TINYINT default 1,
    PRIMARY KEY (fav_id),
    FOREIGN KEY (ctm_id) REFERENCES customers(ctm_id),
    FOREIGN KEY (movie_id) REFERENCES movies(movie_id)
);
CREATE TABLE request(
	req_id			INT AUTO_INCREMENT,
    req_content		NVARCHAR(550) NOT NULL,
    req_stt_send	TINYINT DEFAULT 0,
    req_answer		NVARCHAR(550),
    ctm_id			INT,
	PRIMARY KEY (req_id),
    FOREIGN KEY (ctm_id) REFERENCES customers(ctm_id)
);
CREATE TABLE aboutme(
	verid			INT auto_increment primary key,
	ver				VARCHAR(10),
    notepatch		NVARCHAR(500)
);
-- create new database
DROP DATABASE IF EXISTS csdl_movie;
CREATE DATABASE IF NOT EXISTS csdl_movie;
USE csdl_movie;
-- create tables
CREATE TABLE movie(
	movie_id INT AUTO_INCREMENT,
	movie_name VARCHAR(90) NOT NULL,
	movie_directors VARCHAR(50),
	movie_year INT,
	movie_premiereDay DATE,
	movie_cast NVARCHAR(50) ,
	movie_coverImage VARCHAR(500) ,
	movie_Certificate VARCHAR(20) ,
	PRIMARY KEY (movie_id)
);
CREATE TABLE sources(
	sc_id			INT AUTO_INCREMENT,
    sc_episode		INT,
    sc_url			VARCHAR(550) NOT NULL,
    movie_id		INT,
	PRIMARY KEY (sc_id),
    FOREIGN KEY (movie_id) REFERENCES movie(movie_id)
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
    FOREIGN KEY (movie_id) REFERENCES movie(movie_id)
);
CREATE TABLE contry(
	contry_id			INT AUTO_INCREMENT,
    contry_name		NVARCHAR(35) NOT NULL,
    PRIMARY KEY (contry_id)
);
CREATE TABLE contryClassification(
	id					INT PRIMARY KEY,
	contry_id 			INT,
    movie_id			INT,
	FOREIGN KEY (contry_id) REFERENCES contry(contry_id),
    FOREIGN KEY (movie_id) REFERENCES movie(movie_id)
);
CREATE TABLE customer(
	ctm_id				INT AUTO_INCREMENT,
    ctm_name			NVARCHAR(30) NOT NULL,
    ctm_email			NVARCHAR(50) NOT NULL UNIQUE,
    ctm_brithday		DATE,
    ctm_since			DATE,
    ctm_status			TINYINT,
    ctm_lever			TINYINT,
    ctm_account			VARCHAR(30) NOT NULL UNIQUE,
    ctm_pass			NVARCHAR(32) NOT NULL,
	PRIMARY KEY (ctm_id)
);
CREATE TABLE ListOfFvorites(
	lof_id			INT AUTO_INCREMENT,
    lof_name		NVARCHAR(50) NOT NULL,
    ctm_id			INT,
    movie_id		INT,
    PRIMARY KEY (lof_id),
    FOREIGN KEY (lof_id) REFERENCES customer(ctm_id),
    FOREIGN KEY (lof_id) REFERENCES movie(movie_id)
);
CREATE TABLE reques(
	req_id			INT AUTO_INCREMENT,
    req_content		NVARCHAR(550) NOT NULL,
    req_status		TINYINT NOT NULL,
    ctm_id			INT,
	PRIMARY KEY (req_id),
    FOREIGN KEY (ctm_id) REFERENCES customer(ctm_id)
);
CREATE TABLE aboutme(
	verid			INT auto_increment primary key,
	ver				VARCHAR(10),
    notepatch		NVARCHAR(500)
);
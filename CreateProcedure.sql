USE csdl_movie;
--  create delimiter for register customer
delimiter //
CREATE PROCEDURE createCustomer(IN cus_acc VARCHAR(30), cus_pass VARCHAR(32), cus_name VARCHAR(30), cus_email VARCHAR(50), cus_db DATE)
BEGIN
	INSERT INTO customer (ctm_account, ctm_pass, ctm_name, ctm_email, ctm_status, ctm_lever, ctm_brithday, ctm_since)
    VALUES (cus_acc, cus_pass, cus_name, cus_email, 1, 1, cus_db, CURDATE());
END //
delimiter ;
-- DROP PROCEDURE createCustomer;
-- CALL createCustomer('abcd','12345678','heheh','123@123.com','1999-02-02');



--  create delimiter for login customer
delimiter //
CREATE PROCEDURE loginCustomer(IN cus_acc VARCHAR(30), cus_pass VARCHAR(32))
BEGIN
	SELECT ctm_account, ctm_pass
	FROM customer
	WHERE ctm_account = cus_acc AND ctm_pass = cus_pass;
END //
delimiter ;
-- DROP PROCEDURE loginCustomer;
-- CALL loginCustomer('admin1','long1234');

--  create delimiter for change password
delimiter //
CREATE PROCEDURE changepass(IN cus_id INT, cus_pass VARCHAR(32))
BEGIN
	UPDATE customer
	SET ctm_pass = cus_pass
	WHERE ctm_id = cus_id;
END //
delimiter ;
-- DROP PROCEDURE changepass;

--  create delimiter for update profile
delimiter //
CREATE PROCEDURE updateprofile(IN cus_id INT, cus_name VARCHAR(30), cus_email VARCHAR(50), cus_brithday DATE)
BEGIN
	UPDATE customer
	SET ctm_name = cus_name, ctm_email = cus_email, ctm_brithday = cus_brithday
	WHERE ctm_id = cus_id;
END //
delimiter ;
-- DROP PROCEDURE updateprofile;
-- CALL updateprofile(1,'Long','abc@gmail.com','1994-12-12');

delimiter //
CREATE PROCEDURE sendrequest(IN in2 nvarchar(550), in3 tinyint, in4 int)
BEGIN
	INSERT INTO csdl_movie.`reques` (req_content, req_status, ctm_id)
    VALUES (in2, in3, in4);
END //
delimiter ;

delimiter //
CREATE PROCEDURE search_nation(IN input int)
BEGIN
	SELECT c.movie_id,c.movie_name,c.movie_directors,c.movie_year,c.movie_premiereDay,c.movie_coverImage,c.movie_Certificate
    FROM contry AS a INNER JOIN contryclassification AS b ON a.contry_id = b.contry_id INNER JOIN movie AS c ON b.movie_id = c.movie_id
    WHERE a.contry_id = input;
END //
delimiter ;
-- DROP PROCEDURE search_nation
-- CALL search_nation(5)

delimiter //
CREATE PROCEDURE search_name(IN input VARCHAR(90))
BEGIN
	SELECT movie_id, SUBSTRING(movie_name,1,43) AS movie_name, SUBSTRING(movie_directors,1,28) AS movie_directors, movie_year, movie_premiereDay, SUBSTRING(movie_coverImage,1,70) AS movie_coverImage, movie_Certificate
    FROM movie
    WHERE movie_name LIKE concat('%',input,'%');
END //
delimiter ;
-- DROP PROCEDURE search_name
-- CALL search_name('10')

delimiter //
CREATE PROCEDURE update_mov_info(IN input VARCHAR(90),input2 VARCHAR(50), input3 INT, input4 VARCHAR(500), input5 INT)
BEGIN
	UPDATE movie
	SET movie_name = input, movie_directors = input2 , movie_year = input3 , movie_coverImage = input4
	WHERE movie_id = input5;
END //
delimiter ;
-- DROP PROCEDURE update_mov_info
-- CALL update_mov_info('1-------10--------20--------30--------40--------50--------60--------70--------80','1-------10--------20--------30--------40','2020','1-------10--------20--------30--------40--------50--------60--------70--------80',26)

-- Tran Dai Loi add
ALTER TABLE `csdl_movie`.`reques` 
ADD COLUMN `ans` VARCHAR(550) NULL AFTER `ctm_id`;

delimiter //
CREATE PROCEDURE sendrequest(IN in2 nvarchar(550), in3 tinyint, in4 int)
BEGIN
	INSERT INTO `csdl_movie`.`reques` (`req_content`, `req_status`, `ctm_id`)
    VALUES (in2, in3, in4);
END //
delimiter ;

delimiter //
CREATE PROCEDURE sent(in id int)
BEGIN
	select req_content, req_status, ctm_id, ans
    from csdl_movie.reques
    where ctm_id = id;
END //
delimiter ;


delimiter //
CREATE PROCEDURE reply(IN content varchar(550), id int)
BEGIN
	update reques 
	set req_status = 2, ans = content, req_id = id
	where req_id = id;
END //
delimiter ;


CREATE VIEW bangrequest
AS
SELECT customer.ctm_name ,reques.req_content, customer.ctm_id, reques.req_status
FROM customer INNER JOIN reques ON customer.ctm_id = reques.ctm_id;

SELECT * FROM bangrequest;


delimiter //
CREATE PROCEDURE searchmember_byname(IN input VARCHAR(30))
BEGIN
	SELECT ctm_id, SUBSTRING(ctm_name,1,30) AS ctm_name, SUBSTRING(ctm_email,1,50) AS ctm_email, ctm_brithday, ctm_since, ctm_status, ctm_lever, SUBSTRING(ctm_account,1,70) AS ctm_account, SUBSTRING(ctm_pass,1,70) AS ctm_pass
    FROM customer
    WHERE ctm_name LIKE concat('%',input,'%');
END //
delimiter ;
-- DROP PROCEDURE searchmember_byname;
-- CALL searchmember_byname('Long');

delimiter //
CREATE PROCEDURE updatemember_id(IN input int, inputname VARCHAR(30), inputemail VARCHAR (50), inputdb DATE, setstt int, setlvl int)
BEGIN
	UPDATE customer
    SET ctm_name = inputname, ctm_email = inputemail, ctm_brithday = inputdb, ctm_status = setstt, ctm_lever = setlvl
    WHERE ctm_id = input;
END //
delimiter ;
-- DROP PROCEDURE updatemember_id;
-- CALL searchmember_byname('Long');
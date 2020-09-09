USE csdl_movie;

--  create delimiter for register customer
delimiter //
CREATE PROCEDURE createCustomer(IN cus_acc VARCHAR(30), cus_pass VARCHAR(32), cus_name VARCHAR(30), cus_email VARCHAR(50), cus_db DATE)
BEGIN
	INSERT INTO customers (ctm_account, ctm_pass, ctm_name, ctm_email, ctm_brithday, ctm_since)
    VALUES (cus_acc, cus_pass, cus_name, cus_email, cus_db, CURDATE());
END //
delimiter ;
-- DROP PROCEDURE createCustomer;
-- CALL createCustomer('abcd','12345678','heheh','123@123.com','1999-02-02');

--  create delimiter for login customer
delimiter //
CREATE PROCEDURE loginCustomer(IN cus_acc VARCHAR(30), cus_pass VARCHAR(32))
BEGIN
	SELECT ctm_account, ctm_pass
	FROM customers
	WHERE ctm_account = cus_acc AND ctm_pass = cus_pass;
END //
delimiter ;
-- DROP PROCEDURE loginCustomer;
-- CALL loginCustomer('admin1','long1234');

--  create delimiter for change password
delimiter //
CREATE PROCEDURE changepass(IN cus_id INT, cus_pass VARCHAR(32))
BEGIN
	UPDATE customers
	SET ctm_pass = cus_pass
	WHERE ctm_id = cus_id;
END //
delimiter ;
-- DROP PROCEDURE changepass;
-- CALL changepass(2, abc);

--  create delimiter for update profile
delimiter //
CREATE PROCEDURE updateprofile(IN cus_id INT, cus_name VARCHAR(30), cus_email VARCHAR(50), cus_brithday DATE)
BEGIN
	UPDATE customers
	SET ctm_name = cus_name, ctm_email = cus_email, ctm_brithday = cus_brithday
	WHERE ctm_id = cus_id;
END //
delimiter ;
-- DROP PROCEDURE updateprofile;
-- CALL updateprofile(1,'Long','abc@gmail.com','1994-12-12');

delimiter //
CREATE PROCEDURE search_nation(IN input int)
BEGIN
	SELECT c.movie_id,c.movie_name,c.movie_directors,c.movie_year,c.movie_premiereDay,c.movie_coverImage,c.movie_Certificate, c.movie_Rate, c.movie_Description, e.nation_name, a.tag_name
    FROM tag AS a INNER JOIN tagclassification AS b ON a.tag_id = b.tag_id INNER JOIN movies AS c ON b.movie_id = c.movie_id INNER JOIN nationsclassification AS d ON d.movie_id = c.movie_id INNER JOIN nations AS e ON e.nation_id = d.nation_id
    WHERE e.nation_id = input;
END //
delimiter ;
-- DROP PROCEDURE search_nation
-- CALL search_nation(5)

delimiter //
CREATE PROCEDURE search_name(IN input VARCHAR(90))
BEGIN
    SELECT c.movie_id, SUBSTRING(c.movie_name,1,43) AS movie_name, SUBSTRING(c.movie_directors,1,28) AS movie_directors, c.movie_year, c.movie_premiereDay, SUBSTRING(c.movie_coverImage,1,70) AS movie_coverImage, c.movie_Certificate, c.movie_Rate, c.movie_Description, e.nation_name, a.tag_name
    FROM tag AS a INNER JOIN tagclassification AS b ON a.tag_id = b.tag_id INNER JOIN movies AS c ON b.movie_id = c.movie_id INNER JOIN nationsclassification AS d ON d.movie_id = c.movie_id INNER JOIN nations AS e ON e.nation_id = d.nation_id
    WHERE movie_name LIKE concat('%',input,'%');
END //
delimiter ;
-- DROP PROCEDURE search_name
-- CALL search_name('na')

delimiter //
CREATE PROCEDURE update_mov_info(IN input VARCHAR(90),input2 VARCHAR(50), input3 INT, input4 VARCHAR(500), input5 INT)
BEGIN
	UPDATE movies
	SET movie_name = input, movie_directors = input2 , movie_year = input3 , movie_coverImage = input4
	WHERE movie_id = input5;
END //
delimiter ;
-- DROP PROCEDURE update_mov_info
-- CALL update_mov_info('1-------10--------20--------30--------40--------50--------60--------70--------80','1-------10--------20--------30--------40','2020','1-------10--------20--------30--------40--------50--------60--------70--------80',26)

delimiter //
CREATE PROCEDURE sendrequest(IN in1 nvarchar(550), in2 int)
BEGIN
	INSERT INTO csdl_movie.request (req_content, ctm_id)
    VALUES (in1, in2);
END //
delimiter ;

delimiter //
CREATE PROCEDURE sent(in id int)
BEGIN
	select req_content, req_stt_send, ctm_id, req_answer
    from csdl_movie.request
    where ctm_id = id;
END //
delimiter ;

delimiter //
CREATE PROCEDURE updatemail(IN id int, stt int)
BEGIN
	UPDATE csdl_movie.request
	SET req_stt_send = stt
	WHERE req_id = id;
END //
delimiter ;

delimiter //
CREATE PROCEDURE reply(IN content varchar(550), id int)
BEGIN
	update request
	set req_stt_send = 2, req_answer = content, req_id = id
	where req_id = id;
END //
delimiter ;
-- DROP PROCEDURE reply
-- CALL reply('testcall',2)



CREATE VIEW bangrequest
AS
SELECT customers.ctm_name ,request.req_content, customers.ctm_id, request.req_stt_send, request.req_id
FROM customers INNER JOIN request ON customers.ctm_id = request.ctm_id;
-- DROP VIEW bangrequest
SELECT * FROM bangrequest;

delimiter //
CREATE PROCEDURE searchmember_byname(IN input VARCHAR(30))
BEGIN
	SELECT ctm_id, SUBSTRING(ctm_name,1,30) AS ctm_name, SUBSTRING(ctm_email,1,50) AS ctm_email, ctm_brithday, ctm_since, ctm_status, ctm_lever, SUBSTRING(ctm_account,1,70) AS ctm_account, SUBSTRING(ctm_pass,1,70) AS ctm_pass
    FROM customers
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

delimiter //
CREATE PROCEDURE listfavourite(IN cus_id int)
BEGIN
	SELECT a.movie_id, b.movie_name,b.movie_directors,b.movie_year,b.movie_premiereDay,b.movie_coverImage,b.movie_Certificate
	FROM favourites AS a INNER JOIN movies AS b ON a.movie_id = b.movie_id
	WHERE a.ctm_id = cus_id AND a.stt = 1
    GROUP BY a.movie_id;
END //
delimiter ;
-- DROP PROCEDURE listfavourite
-- CALL listfavourite(1)

delimiter //
CREATE PROCEDURE addfavouritelist(IN input int, input2 int)
BEGIN
	INSERT INTO favourites (ctm_id, movie_id)
	VALUES (input, input2);
END //
delimiter ;
-- DROP PROCEDURE addfavouritelist
-- CALL addfavouritelist(5,21)

delimiter //
CREATE PROCEDURE rvfavouritelist(IN input int, input2 int)
BEGIN
	UPDATE favourites
	SET stt = 2
    WHERE ctm_id = input AND movie_id = input2;
END //
delimiter ;
-- DROP PROCEDURE rvfavouritelist
-- CALL rvfavouritelist(1,2)

delimiter //
CREATE PROCEDURE movie_information()
BEGIN
	SELECT a.movie_id, a.movie_name,a.movie_directors,a.movie_year,a.movie_premiereDay,a.movie_coverImage,a.movie_Certificate,a.movie_Rate,a.movie_Description,c.nation_name,e.tag_name
	FROM csdl_movie.movies AS a 
	INNER JOIN csdl_movie.nationsclassification AS b ON a.movie_id = b.movie_id
	INNER JOIN csdl_movie.nations AS c ON b.nation_id = c.nation_id
	INNER JOIN csdl_movie.tagclassification AS d ON a.movie_id = d.movie_id
	INNER JOIN csdl_movie.tag AS e ON d.tag_id = e.tag_id;
END //
delimiter ;
-- DROP PROCEDURE movie_information
-- CALL movie_information()

delimiter //
CREATE PROCEDURE search_tag(IN input int)
BEGIN
	SELECT c.movie_id,c.movie_name,c.movie_directors,c.movie_year,c.movie_premiereDay,c.movie_coverImage,c.movie_Certificate, c.movie_Rate, c.movie_Description, e.nation_name, a.tag_name
    FROM tag AS a INNER JOIN tagclassification AS b ON a.tag_id = b.tag_id INNER JOIN movies AS c ON b.movie_id = c.movie_id INNER JOIN nationsclassification AS d ON d.movie_id = c.movie_id INNER JOIN nations AS e ON e.nation_id = d.nation_id
    WHERE a.tag_id = input;
END //
delimiter ;
-- DROP PROCEDURE search_tag
-- CALL search_tag(6)

delimiter //
CREATE PROCEDURE updatefavouritelist(IN input int, input2 int)
BEGIN
	UPDATE favourites
	SET stt = 1
	WHERE ctm_id = input AND movie_id = input2;
END //
delimiter ;
-- DROP PROCEDURE updatefavouritelist
-- CALL updatefavouritelist(1,2)
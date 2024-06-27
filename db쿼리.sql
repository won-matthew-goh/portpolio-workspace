-- root사용자에서 moviego / 0000 계정 먼저 만들기
use mysql;
select * from user;
create user 'moviego'@'localhost' identified by '0000';
create user 'moviego'@'%' identified by '0000';

create database moviego;

grant all privileges on moviego.* to 'moviego'@'localhost';
grant all privileges on moviego.* to 'moviego'@'%';

flush privileges;

create database moviego;

-- moviego 유저로 접속 후

use moviego;

create table tb_users(
	user_id int(10) not null auto_increment,
    username varchar(50),
    passwd varchar(50),
    email varchar(50),
    created_at datetime default current_timestamp,
    deleted_at datetime,
    provider varchar(20),
    provider_id varchar(50),
    primary key(user_id),
    unique index(username, email)
);

create table tb_reviews(
	review_id int not null auto_increment,
    user_id int,
    rating float,
    comment text,
    read_cnt int,
    report_cnt int,
    created_at datetime default current_timestamp,
    updated_at datetime,
    deleted_at datetime,
    primary key(review_id)
);
    
-- reviews의 user_id FK 설정 한 뒤,

DELIMITER $$
DROP PROCEDURE IF EXISTS loopInsert$$


CREATE PROCEDURE loopInsert()
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE j INT DEFAULT 1;

    WHILE i <= 10 DO
    	WHILE j <=10 DO
        	INSERT INTO tb_reviews(user_id, rating , comment , created_at)
          	VALUES (i, (0.5 * j), '엄청 재밌어요 아하하하하하', now());
          SET j = j + 1;
         END WHILE;
        SET j = 1;
        SET i = i + 1;
    END WHILE;
END$$
DELIMITER $$


CALL loopInsert;
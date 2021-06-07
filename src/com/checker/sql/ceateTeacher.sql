USE mybatis;

# DROP TABLE teacher;

CREATE TABLE IF NOT EXISTS teacher
(
    tid        INT(11) NOT NULL AUTO_INCREMENT,
    tname      VARCHAR(100),
    class_name VARCHAR(100),
    address    VARCHAR(100),
    birth_day  date,
    PRIMARY KEY (tid)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;

INSERT INTO teacher(tname, class_name, address, birth_day)
VALUES ("aa","一班","海珠","2020-05-07"),
       ("bb","二班","荔湾","2018-04-03"),
       ("cc","三班","天河","2017-08-12");

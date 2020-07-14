
DROP TABLE IF EXISTS `book`;

CREATE TABLE book
(
    bid INT AUTO_INCREMENT NOT NULL ,
    bookName VARCHAR(255) NOT NULL,
    author VARCHAR(50) NOT NULL,
    type VARCHAR(255) NOT NULL,
    publisher VARCHAR(255) NOT NULL,
    publicationDate VARCHAR(255) NOT NULL,
    price INT(11) NOT NULL,
    status INT(11) NOT NULL,
    remark VARCHAR(255) NOT NULL,
    PRIMARY KEY (`bid`)
);
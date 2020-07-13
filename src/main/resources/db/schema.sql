
DROP TABLE IF EXISTS `book`;

CREATE TABLE book
(
    id INT PRIMARY KEY NOT NULL,
    bookName VARCHAR(255) NOT NULL,
    author VARCHAR(50) NOT NULL,
    type VARCHAR(255) NOT NULL,
    publisher VARCHAR(255) NOT NULL,
    publicationDate VARCHAR(255) NOT NULL,
    price INT(11) NOT NULL,
    status INT(11) NOT NULL,
    remark VARCHAR(255) NOT NULL
);
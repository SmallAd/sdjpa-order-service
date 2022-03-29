DROP TABLE IF EXISTS order_header CASCADE;

CREATE TABLE order_header
(
    id       bigint not null auto_increment primary key,
    customer varchar(255)
) engine = InnoDB;

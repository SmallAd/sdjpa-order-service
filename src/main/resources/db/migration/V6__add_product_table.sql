CREATE TABLE product
(
    id                 BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    description        VARCHAR(100),
    product_status     VARCHAR(20),
    created_date       timestamp,
    last_modified_date timestamp
) engine = InnoDB;
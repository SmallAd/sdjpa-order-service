CREATE TABLE order_line
(
    id bigint not null auto_increment primary key,
    quantity_ordered int,
    order_header_id bigint not null,
    created_date timestamp,
    last_modified_date timestamp,
    CONSTRAINT order_header_pk FOREIGN KEY (order_header_id) REFERENCES order_header(id)
) engine = innoDB;
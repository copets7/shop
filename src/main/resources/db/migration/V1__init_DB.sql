
create table buckets (
     id bigint not null auto_increment,
     user_id bigint,
     primary key (id))
     engine=InnoDB;

create table buckets_products (
     bucket_id bigint not null,
     product_id bigint not null)
     engine=InnoDB;

create table categories (
     id bigint not null auto_increment,
     title varchar(255),
     primary key (id))
     engine=InnoDB;

create table orders (
     id bigint not null auto_increment,
     address varchar(255),
     created datetime(6),
     status varchar(255),
     sum decimal(19,2),
     updated datetime(6),
     user_id bigint,
     primary key (id))
     engine=InnoDB;

create table orders_details (
     id bigint not null auto_increment,
     amount decimal(19,2),
     price decimal(19,2),
     order_id bigint,
     product_id bigint,
     details_id bigint not null,
     primary key (id))
     engine=InnoDB;

create table products (
    id bigint not null auto_increment,
    price decimal(19,2), title varchar(255),
    primary key (id))
    engine=InnoDB;

create table products_categories (
    product_id bigint not null,
    category_id bigint not null)
    engine=InnoDB;

create table users (
    id bigint not null auto_increment,
    archive bit not null,
    email varchar(255),
    name varchar(255),
    password varchar(255),
    role varchar(255),
    bucket_id bigint,
    primary key (id))
    engine=InnoDB;

